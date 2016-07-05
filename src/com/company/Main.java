package com.company;
//Issue: startet beim letzten Tag eine Zeile zu früh
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        KassandroReader a = new KassandroReader();

        ArrayList<Kassapos> kPoses = a.getKPoses("/home/cleitgeb/Downloads/raw.csv", ";", true);

        ArrayList<DailyTurnover> dTurn = new ArrayList<>();

        DailyTurnover b = new DailyTurnover();
        for(int i = 0; i < kPoses.size(); i++){
            int j = i +1;
            if(j == kPoses.size()){
                j = i;
            }


            if(kPoses.get(i).getDate() != kPoses.get(j).getDate()){

                //Codeverdoppelung
                b.addAmount(kPoses.get(i).getBruttoPrice());
                b.setNettoAmount(kPoses.get(i).getNettoPrice());
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
            b.setNettoAmount(kPoses.get(i).getNettoPrice());
            b.setDate(kPoses.get(i).getDate());
            if(kPoses.get(i).getVatRate() == 10){
                b.setVatLow(kPoses.get(i).getVatAmount());
            } else {
                b.setVatNormal(kPoses.get(i).getVatAmount());

            }

            System.out.println(i +1 + " " + kPoses.get(i).getName() + " " + b.getDate() + " " + b.getNettoAmount());

            if(i == (kPoses.size() - 1)){
                b.addAmount(kPoses.get(i).getBruttoPrice());
                b.setNettoAmount(kPoses.get(i).getNettoPrice());
                b.setDate(kPoses.get(i).getDate());
                if(kPoses.get(i).getVatRate() == 10){
                    b.setVatLow(kPoses.get(i).getVatAmount());
                } else {
                    b.setVatNormal(kPoses.get(i).getVatAmount());
                }


                dTurn.add(b);
                b = new DailyTurnover();
            }


        }



        for(int i = 0; i < dTurn.size();i++){
            System.out.println(dTurn.get(i).getDate() + ";" + dTurn.get(i).getAmount() + ";" + dTurn.get(i).getNettoAmount() + ";" + dTurn.get(i).getVatLow() + ";" + dTurn.get(i).getVatNormal());
        }

    }
}
