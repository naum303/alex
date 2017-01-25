
## Examples
### Dialog model:
    User: "Alexa, tell score keeper to reset."
    Alexa: "New game started without players. Who do you want to add first?"
    User: "Add the player Bob"
    Alexa: "Bob has joined your game"
    User: "Add player Jeff"
    Alexa: "Jeff has joined your game"

    (skill saves the new game and ends)

    User: "Alexa, tell score keeper to give Bob three points."
    Alexa: "Updating your score, three points for Bob"

    (skill saves the latest score and ends)

### One-shot model:
    User: "Alexa, ask score keeper what's the current score?"
    Alexa: "Jeff has zero points and Bob has three"
