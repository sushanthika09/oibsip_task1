package bank;

public class Atm {
    private String names[];
    private double balances[];
    private int nClients;

    public Atm() {
    this(0);
    }

    public bank(int size) {
        nClients = 0;
        balances = new double[size];
        names = new String[size];

    }
    public int findIndexByName(String name) {
        for(int i = 0; i < nClients; i++)
        {
            if(names[i].equalsIgnoreCase(name))
                return i;

        }
        return -1;

    }

    public boolean addClient(String name , double balance) {

        if(nClients < names.length && nClients < balances.length) {
            int index = findIndexByName(name);
            if(index == -1){
                names[nClients] = name;
                balances[nClients]=balance;
                nClients++;
                return true;
            }

            return false;
        }
        return false; //no space to add

    }

    public boolean deleteClient(String name) { //wrong
        int index = findIndexByName(name);
        if(index == -1) {
            return false;
        }


        else {
            names[index] = names[nClients];
            balances[index ]= balances[nClients];
            nClients--;
            return true;


        }


    }

    public boolean deposit(String name , double amount) {
        int index = findIndexByName(name);
        if (index == -1)
            return false;
        double temp= balances[index];
        balances[index] += amount ;
        System.out.println(names[index] + "was " + temp + "now " + balances[index] );
        return true;

    }

    public boolean withdraw(String name , double amount) {
    int index=findIndexByName(name);
    if (index==-1 && balances[index]<amount)
        return false;
    else{
        double temp= balances[index];
        balances[index]-=amount;
        System.out.println(names[index]+" was"+ temp+", "+balances[index]);
        return  true;
    }



    }

    public boolean transfer(String fName , String tName , double amount) {
        int index1=findIndexByName(fName);
        int index2=findIndexByName(tName);
        if (index1 ==-1 || index2==-1 ||balances[index1]<amount){
            return false;
        }else {
            withdraw(fName,amount);
            deposit(tName,amount);
            return true;

        }


    }

    public void display(String name) {
        int index = findIndexByName(name);
        if(index == -1)
            System.out.println("Not found");


        else
        {
            System.out.println(names[index]+" "+ balances[index] + " SR");//wrong
        }


    }

    public String findmax() {//wrong
        if(nClients == 0)
            return null;
        double max = 0;
        int counter=0;
        for(int i =0; i < nClients; i++){
            if (max<balances[i]){
                max=balances[i];
                counter=i;

            }

        }


        return names[counter];
    }






}