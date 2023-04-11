import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * @author ${BENMOUSSA-Younes}
 * @created ${2023/04}
 * @project ${Simulation of an update of the scalar (logical) clocks of 2 sites}
 */

public class agentOne extends Agent {
    int index = 0 ;
    int clock = 0 ;
    public void setup(){
        System.out.println("--------------");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                index+=1;
                System.out.println("A : "+index);
                block(1000);
                clock += 1;
                System.out.println("clock A --> "+clock);
                if( index%100 == 0){
                    System.out.println("Sending Msg to site B ...");
                    // init content
                    String content = String.valueOf(clock);
                    ACLMessage message  = new ACLMessage(ACLMessage.INFORM);
                    message.addReceiver(new AID("site2", AID.ISLOCALNAME));
                    message.setContent(content);
                    // send message
                    send(message);
                }
            }
        });
    }
}
