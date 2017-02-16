/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package de.alex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

/**
 * The {@link MeineVertraegeManager} receives various events and intents and
 * manages the flow of the game.
 */
@Component
public class MeineVertraegeManager {


	@Autowired
	private VertragRepository repository;

	/**
	 * Creates and returns response for Launch request.
	 *
	 * @param request
	 *            {@link LaunchRequest} for this request
	 * @param session
	 *            Speechlet {@link Session} for this request
	 * @return response for launch request
	 */
	public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
		// Speak welcome message and ask user questions
		// based on whether there are players or not.
		String speechText = "";
		String repromptText = "";


		return getAskSpeechletResponse(speechText, repromptText);
	}

	public SpeechletResponse getAlleVertraegeResponse(Session session, SkillContext skillContext) {
		List<Vertrag> vertraege = repository.getVertraege();
		
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText("Du hast " + vertraege.size() + " Vertraege.");
		
		return SpeechletResponse.newTellResponse(speech);
	}

	public SpeechletResponse getVertraegeZuSparteResponse(Session session, SkillContext skillContext) {
		return null;
	}

	public SpeechletResponse getVertragZuVSNRResponse(Session session, SkillContext skillContext) {
		return null;
	}

	/**
	 * Creates and returns response for the help intent.
	 *
	 * @param intent
	 *            {@link Intent} for this request
	 * @param session
	 *            {@link Session} for this request
	 * @param skillContext
	 *            {@link SkillContext} for this request
	 * @return response for the help intent
	 */
	public SpeechletResponse getHelpIntentResponse(Intent intent, Session session,
			SkillContext skillContext) {
		return skillContext.needsMoreHelp() ? getAskSpeechletResponse(
				MeineVertraegeTextUtil.COMPLETE_HELP + " So, how can I help?",
				MeineVertraegeTextUtil.NEXT_HELP)
				: getTellSpeechletResponse(MeineVertraegeTextUtil.COMPLETE_HELP);
	}

	/**
	 * Creates and returns response for the exit intent.
	 *
	 * @param intent
	 *            {@link Intent} for this request
	 * @param session
	 *            {@link Session} for this request
	 * @param skillContext
	 *            {@link SkillContext} for this request
	 * @return response for the exit intent
	 */
	public SpeechletResponse getExitIntentResponse(Intent intent, Session session,
			SkillContext skillContext) {
		return skillContext.needsMoreHelp() ? getTellSpeechletResponse("Okay. Whenever you're "
				+ "ready, you can start giving points to the players in your game.")
				: getTellSpeechletResponse("");
	}

	/**
	 * Returns an ask Speechlet response for a speech and reprompt text.
	 *
	 * @param speechText
	 *            Text for speech output
	 * @param repromptText
	 *            Text for reprompt output
	 * @return ask Speechlet response for a speech and reprompt text
	 */
	private SpeechletResponse getAskSpeechletResponse(String speechText, String repromptText) {
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle("Session");
		card.setContent(speechText);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		// Create reprompt
		PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
		repromptSpeech.setText(repromptText);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromptSpeech);

		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

	/**
	 * Returns a tell Speechlet response for a speech and reprompt text.
	 *
	 * @param speechText
	 *            Text for speech output
	 * @return a tell Speechlet response for a speech and reprompt text
	 */
	private SpeechletResponse getTellSpeechletResponse(String speechText) {
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle("Session");
		card.setContent(speechText);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return SpeechletResponse.newTellResponse(speech, card);
	}
}
