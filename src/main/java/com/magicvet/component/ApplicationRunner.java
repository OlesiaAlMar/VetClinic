package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;


public class ApplicationRunner {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.println("Client registration successful.");
                System.out.print("Do you want to add a pet now? (yes/no): ");
                String answer = Main.SCANNER.nextLine().toLowerCase();

                if (answer.equals("yes")) {
                    //addPet(client);
                    registerPets(client);
                }
                System.out.println("Client details:");
                System.out.println(client);
            } else {
                System.out.println("Client registration failed.");
            }
        } else {
            System.out.println("Authentication failed.");
        }
    }

   private void registerPets (Client client) {
boolean continueAddPets = true;
while(continueAddPets){
    addPet(client);
    System.out.print("Do you want to add more pets for the current client? (y/n): ");
    String answer = Main.SCANNER.nextLine();

    if("n".equals(answer)){
        continueAddPets = false;
    }
}
   }

       private void addPet(Client client) {
           System.out.println("Adding a new pet.");
           Pet pet = petService.registerNewPet();

           if(pet != null) {
           client.addPetList(pet);
           pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
           System.out.println("Pet has been added.");}
    }
}
