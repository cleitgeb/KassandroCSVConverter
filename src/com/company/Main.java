package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        KassandroReader a = new KassandroReader();

        ArrayList<Kassapos> kPoses = a.getKPoses("/home/cleitgeb/Downloads/test.csv", ";", true);

        ArrayList<DailyTurnover> dTurn = new ArrayList<>();

        DailyTurnover b = new DailyTurnover();
        for(int i = 0; i < kPoses.size() - 1; i++){

            if(kPoses.get(i).getDate() != kPoses.get(i + 1).getDate()){

                //Codeverdoppelung
                b.addAmount(kPoses.get(i).getBruttoPrice());
                b.setDate(kPoses.get(i).getDate());
                if(kPoses.get(i).getVatRate() == 10){
                    b.setVatLow(kPoses.get(i).getVatAmount());
                } else {
                    b.setVatNormal(kPoses.get(i).getVatAmount());
                }


                dTurn.add(b);
                b = new DailyTurnover();
            }

            b.addAmount(kPoses.get(i).getBruttoPrice());
            b.setDate(kPoses.get(i).getDate());
            if(kPoses.get(i).getVatRate() == 10){
                b.setVatLow(kPoses.get(i).getVatAmount());
            } else {
                b.setVatNormal(kPoses.get(i).getVatAmount());
            }


        }



        for(int i = 0; i < dTurn.size();i++){
            System.out.println(dTurn.get(i).getDate() + ";" + dTurn.get(i).getAmount() + ";" + dTurn.get(i).getVatLow() + ";" + dTurn.get(i).getVatNormal());
        }

    }
}
