/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package de.alex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * This sample shows how to create a Lambda function for handling Alexa Skill
 * requests that:
 *
 * <ul>
 * <li><b>Multiple slots</b>: has 2 slots (name and score)</li>
 * <li><b>Database Interaction</b>: demonstrates how to read and write data to
 * DynamoDB.</li>
 * <li><b>NUMBER slot</b>: demonstrates how to handle number slots.</li>
 * <li><b>Custom slot type</b>: demonstrates using custom slot types to handle a
 * finite set of known values</li>
 * <li><b>Dialog and Session state</b>: Handles two models, both a one-shot ask
 * and tell model, and a multi-turn dialog model. If the user provides an
 * incorrect slot in a one-shot model, it will direct to the dialog model. See
 * the examples section below for sample interactions of these models.</li>
 * </ul>
 * <p>
 * <h2>Examples</h2>
 * <p>
 * <b>Dialog model</b>
 * <p>
 * User: "Alexa, tell score keeper to reset."
 * <p>
 * Alexa: "New game started without players. Who do you want to add first?"
 * <p>
 * User: "Add the player Bob"
 * <p>
 * Alexa: "Bob has joined your game"
 * <p>
 * User: "Add player Jeff"
 * <p>
 * Alexa: "Jeff has joined your game"
 * <p>
 * (skill saves the new game and ends)
 * <p>
 * User: "Alexa, tell score keeper to give Bob three points."
 * <p>
 * Alexa: "Updating your score, three points for Bob"
 * <p>
 * (skill saves the latest score and ends)
 * <p>
 * <b>One-shot model</b>
 * <p>
 * User: "Alexa, what's the current score?"
 * <p>
 * Alexa: "Jeff has zero points and Bob has three"
 */
@Service
public class MeineVertraegeSpeechlet implements Speechlet {
	private static final Logger log = LoggerFactory.getLogger(MeineVertraegeSpeechlet.class);

	// private AmazonDynamoDBClient amazonDynamoDBClient;

	@Autowired
	private MeineVertraegeManager meineVertraegeManager;

	@Autowired
	private SkillContext skillContext;

	@Override
	public void onSessionStarted(final SessionStartedRequest request, final Session session)
			throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
				session.getSessionId());

		// if user said a one shot command that triggered an intent event,
		// it will start a new session, and then we should avoid speaking too
		// many words.
		skillContext.setNeedsMoreHelp(false);
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
			throws SpeechletException {
		log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
				session.getSessionId());

		skillContext.setNeedsMoreHelp(true);
		return meineVertraegeManager.getLaunchResponse(request, session);
	}

	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session)
			throws SpeechletException {
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
				session.getSessionId());

		Intent intent = request.getIntent();

		if ("AlleVertraegeIntent".equals(intent.getName())) {
			return meineVertraegeManager.getAlleVertraegeResponse(session, skillContext);

		} else if ("VertraegeZuSparteIntent".equals(intent.getName())) {
			return meineVertraegeManager.getVertraegeZuSparteResponse(session, skillContext);

		} else if ("VertragZuVSNR".equals(intent.getName())) {
			return meineVertraegeManager.getVertragZuVSNRResponse(session, skillContext);

		} else if ("NewGameIntent".equals(intent.getName())) {
			return meineVertraegeManager.getNewGameIntentResponse(session, skillContext);

		} else if ("AddPlayerIntent".equals(intent.getName())) {
			return meineVertraegeManager.getAddPlayerIntentResponse(intent, session, skillContext);

		} else if ("AddScoreIntent".equals(intent.getName())) {
			return meineVertraegeManager.getAddScoreIntentResponse(intent, session, skillContext);

		} else if ("TellScoresIntent".equals(intent.getName())) {
			return meineVertraegeManager.getTellScoresIntentResponse(intent, session);

		} else if ("ResetPlayersIntent".equals(intent.getName())) {
			return meineVertraegeManager.getResetPlayersIntentResponse(intent, session);

		} else if ("AMAZON.HelpIntent".equals(intent.getName())) {
			return meineVertraegeManager.getHelpIntentResponse(intent, session, skillContext);

		} else if ("AMAZON.CancelIntent".equals(intent.getName())) {
			return meineVertraegeManager.getExitIntentResponse(intent, session, skillContext);

		} else if ("AMAZON.StopIntent".equals(intent.getName())) {
			return meineVertraegeManager.getExitIntentResponse(intent, session, skillContext);

		} else {
			throw new IllegalArgumentException("Unrecognized intent: " + intent.getName());
		}
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session)
			throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
				session.getSessionId());
		// any cleanup logic goes here
	}

}
