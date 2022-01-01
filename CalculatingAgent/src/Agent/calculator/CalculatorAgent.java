package Agent.calculator;

import jade.core.Agent;
import java.lang.Math;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class CalculatorAgent extends Agent{
	private CalculatorGui myGui;
	
	protected void setup() {
		System.out.println("Hallo! Calculator-agent "+getAID().getName()+" is ready.");
		myGui = new CalculatorGui(this);
		myGui.showGui();
		
		
	}
	public void calculateSqure(final int n1) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				double answer = Math.pow(n1, 2);
				System.out.println("Squre of " + n1 + " is = " + answer);
			}
		} );
	}
	public void calculateCube(final int n2) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				double answer = Math.pow(n2, 3);
				System.out.println("Cube of " + n2 + " is = " + answer);
			}
		} );
	}

	
}