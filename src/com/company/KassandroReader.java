package com.company;

/**
 * Created by cleitgeb on 05.07.16.
 */
import java.io.*;
import java.util.ArrayList;

public class KassandroReader     {

    ArrayList<Kassapos> kPoses = new ArrayList<>();
    Boolean _header = true;

    //split by ";"
    public ArrayList<Kassapos> getKPoses(String csvFile, String csvSplitBy, Boolean header) {


        BufferedReader br = null;
        String line = "";
        _header = header;

        File file = new File(csvFile);




        try {
            replaceInFileQuotes(file);
            replaceInFileDots(file);
            replaceInFileMinus(file);

            int i = 1;

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                if(_header != true) {


                    String[] kassaPosAr = line.split(csvSplitBy);
                    kPoses.add(new Kassapos(Integer.parseInt(kassaPosAr[0]), kassaPosAr[11], Integer.parseInt(kassaPosAr[5]), Integer.parseInt(kassaPosAr[10]), Double.parseDouble(kassaPosAr[9]), Double.parseDouble(kassaPosAr[7])));
                }


               _header = false;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return kPoses;
    }

    public void replaceInFileQuotes(File file) throws IOException {

        File tempFile = File.createTempFile("buffer", ".tmp");
        FileWriter fw = new FileWriter(tempFile);

        Reader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            fw.write(br.readLine().replaceAll("\"", "") + "\n");
        }

        fw.close();
        br.close();
        fr.close();

        // Finally replace the original file.
        tempFile.renameTo(file);
    }

    public void replaceInFileDots(File file) throws IOException {

        File tempFile = File.createTempFile("buffer", ".tmp");
        FileWriter fw = new FileWriter(tempFile);

        Reader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            fw.write(br.readLine().replaceAll(",", ".") + "\n");
        }

        fw.close();
        br.close();
        fr.close();

        // Finally replace the original file.
        tempFile.renameTo(file);
    }

    public void replaceInFileMinus(File file) throws IOException {

        File tempFile = File.createTempFile("buffer", ".tmp");
        FileWriter fw = new FileWriter(tempFile);

        Reader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while(br.ready()) {
            fw.write(br.readLine().replaceAll("-", "") + "\n");
        }

        fw.close();
        br.close();
        fr.close();

        // Finally replace the original file.
        tempFile.renameTo(file);
    }

}
