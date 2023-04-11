import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class agentTwo extends Agent {
    int index = 0;
    int clock = 0;
    public void setup(){
            addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {
                    ACLMessage message = myAgent.receive();
                    if (message == null) {
                        index += 1;
                        System.out.println("B : " + index);
                        if (index % 2 == 0) {
                            clock += 1;
                        }
                        block(1000);
                        System.out.println("clock B --> " + clock);
                    }else{
                        // Receiving the message
                        String content = message.getContent();
                        System.out.println("Site 2 received the message  ( " + content+" )");
                        clock = Integer.valueOf(content);
                        System.out.println("Updating Site 2 Clock   :  " + content);
                    }
                }
            });
        }
    }

