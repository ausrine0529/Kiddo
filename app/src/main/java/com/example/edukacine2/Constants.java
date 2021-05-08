package com.example.edukacine2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Constants {

    public static List<Question> getType1Lvl1(int quant){
        List<Question> qstList = new ArrayList<>();
        Question qst1_1_1 = new Question(1, "Kiek dviratis turi ratų?", R.drawable.dviratis, 1, 1, "1", "2", "3", 2);
        Question qst1_1_2 = new Question(2, "Kiek matai balionų?", R.drawable.balionaitrys, 1, 1, "4", "2", "3", 3 );
        Question qst1_1_3 = new Question(3, "Kiek matai bananų?", R.drawable.bananaitrys, 1, 1, "3", "2", "4", 1 );
        Question qst1_1_4 = new Question(4, "Kiek matai delfinų?", R.drawable.delfinaidu, 1, 1, "4", "2", "3", 2 );
        Question qst1_1_5 = new Question(5, "Kiek matai debesėlių?", R.drawable.debesysdu, 1, 1, "1", "2", "3", 2 );
        Question qst1_1_6 = new Question(6, "Kiek matai gėlių?", R.drawable.gelestrys, 1, 1, "4", "2", "3", 3 );
        Question qst1_1_7 = new Question(7, "Kiek matai tulpių?", R.drawable.tulpestrys, 1, 1, "1", "3", "2", 2 );
        Question qst1_1_8 = new Question(8, "Kiek matai grybų?", R.drawable.grybaidu, 1, 1, "1", "2", "3", 2 );
        Question qst1_1_9 = new Question(9, "Kiek matai musmirių?", R.drawable.grybaitrys, 1, 1, "2", "3", "4", 2 );
        Question qst1_1_10 = new Question(10, "Kiek matai kačių?", R.drawable.kate, 1, 1, "1", "2", "3", 1 );
        Question qst1_1_11 = new Question(11, "Kiek kiškis turi ausų?", R.drawable.kiskis, 1, 1, "1", "2", "3", 2 );
        Question qst1_1_12 = new Question(12, "Kiek matai knygų?", R.drawable.knygosdvi, 1, 1, "2", "3", "4", 1 );
        Question qst1_1_13 = new Question(13, "Kiek matai lapių?", R.drawable.lape, 1, 1, "2", "3", "1", 3);
        Question qst1_1_14 = new Question(14, "Kiek matai mašinų?", R.drawable.masina, 1, 1, "2", "1", "4", 2 );
        Question qst1_1_15 = new Question(15, "Kiek matai ledų?", R.drawable.trysledai, 1, 1, "2", "3", "4", 2 );
        qstList.add(qst1_1_1);
        qstList.add(qst1_1_2);
        qstList.add(qst1_1_3);
        qstList.add(qst1_1_4);
        qstList.add(qst1_1_5);
        qstList.add(qst1_1_6);
        qstList.add(qst1_1_7);
        qstList.add(qst1_1_8);
        qstList.add(qst1_1_9);
        qstList.add(qst1_1_10);
        qstList.add(qst1_1_11);
        qstList.add(qst1_1_12);
        qstList.add(qst1_1_13);
        qstList.add(qst1_1_14);
        qstList.add(qst1_1_15);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType1Lvl2(int quant){
        List<Question> qstList = new ArrayList<>();
        Question qst1_2_1 = new Question(24, "Kiek pirštų turi delnas?", R.drawable.delnas, 2, 1, "6", "5", "4", 2);
        Question qst1_2_2 = new Question(25, "Kiek matai žvaigždžių?", R.drawable.keturioszvaigzdes, 2, 1, "4", "2", "3", 1 );
        Question qst1_2_3 = new Question(26, "Kiek matai žirafų?", R.drawable.keutrioszirafos, 2, 1, "3", "2", "4", 3 );
        Question qst1_2_4 = new Question(27, "Kiek laumžirgis turi sparnų?", R.drawable.laumzirgis, 2, 1, "4", "2", "3", 1 );
        Question qst1_2_5 = new Question(28, "Kiek matai pėdučių?", R.drawable.pedos, 2, 1, "4", "2", "3", 1 );
        Question qst1_2_6 = new Question(29, "Kiek matai balionų?", R.drawable.penkibalionai, 2, 1, "4", "6", "5", 3 );
        Question qst1_2_7 = new Question(30, "Kiek matai gėlių?", R.drawable.penkiosgeles, 2, 1, "4", "5", "6", 2 );
        Question qst1_2_8 = new Question(31, "Kiek matai žvakučių?", R.drawable.penkioszvakes, 2, 1, "5", "6", "7", 1 );
        Question qst1_2_9 = new Question(32, "Kiek matai spurgų?", R.drawable.sesiosspurgos, 2, 1, "5", "6", "7", 2 );
        Question qst1_2_10 = new Question(33, "Kiek matai žvaigždžių?", R.drawable.sesioszvaigzdes, 2, 1, "5", "6", "7", 2 );
        qstList.add(qst1_2_1);
        qstList.add(qst1_2_2);
        qstList.add(qst1_2_3);
        qstList.add(qst1_2_4);
        qstList.add(qst1_2_5);
        qstList.add(qst1_2_6);
        qstList.add(qst1_2_7);
        qstList.add(qst1_2_8);
        qstList.add(qst1_2_9);
        qstList.add(qst1_2_10);


        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType1Lvl3(int quant){
        List<Question> qstList = new ArrayList<>();
        Question qst1_3_1 = new Question(34, "Kiek matai šuniukų?", R.drawable.astuonisunys, 3, 1, "8", "9", "10", 1);
        Question qst1_3_2 = new Question(35, "Kiek aštuonkojis turi čiuptuvų?", R.drawable.astuonkojis, 3, 1, "7", "6", "8", 3 );
        Question qst1_3_3 = new Question(36, "Kiek matai pieštukų?", R.drawable.desimtpiestuku, 3, 1, "9", "10", "11", 2 );
        Question qst1_3_4 = new Question(37, "Kiek matai širdelių", R.drawable.devyniossirdeles, 3, 1, "9", "7", "8", 1 );
        Question qst1_3_5 = new Question(38, "Kiek matai keksiukų?", R.drawable.dvylikakeksiuku, 3, 1, "10", "11", "12", 3 );
        Question qst1_3_6 = new Question(39, "Kiek matai pištukų?", R.drawable.dvylikapiestuku, 3, 1, "9", "10", "12", 3 );
        Question qst1_3_7 = new Question(40, "Kiek matai vaikų?", R.drawable.penkivaikai, 3, 1, "4", "5", "6", 2 );
        Question qst1_3_8 = new Question(41, "Kiek matai drambliukų?", R.drawable.septynidrambliai, 3, 1, "5", "6", "7", 3 );
        Question qst1_3_9 = new Question(42, "Kiek matai kėglių?", R.drawable.septynikegliai, 3, 1, "5", "6", "7", 3 );
        Question qst1_3_10 = new Question(43, "Kiek matai žvakių?", R.drawable.septynioszvakes, 3, 1, "5", "6", "7", 3 );
        qstList.add(qst1_3_1);
        qstList.add(qst1_3_2);
        qstList.add(qst1_3_3);
        qstList.add(qst1_3_4);
        qstList.add(qst1_3_5);
        qstList.add(qst1_3_6);
        qstList.add(qst1_3_7);
        qstList.add(qst1_3_8);
        qstList.add(qst1_3_9);
        qstList.add(qst1_3_10);


        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType2Lvl1(int quant){
        List<Question> qstList = new ArrayList<>();
        Question qst2_1_1 = new Question(16, "Koks tai žodis?", R.drawable.gile, 1, 2, "GILĖ", "SOFA", "LOVA", 1);
        Question qst2_1_2 = new Question(17, "Koks tai žodis?", R.drawable.lape, 1, 2, "GILĖ", "LAPĖ", "KATĖ", 2 );
        Question qst2_1_3 = new Question(18, "Koks tai žodis?", R.drawable.kate, 1, 2, "SAGA", "KATĖ", "ŠUO", 2 );
        Question qst2_1_4 = new Question(19, "Koks tai žodis?", R.drawable.saga, 1, 2, "UOLA", "PELĖ", "SAGA", 2 );
        Question qst2_1_5 = new Question(20, "Koks tai žodis?", R.drawable.avis, 1, 2, "KATĖ", "OŽKA", "AVIS", 3 );
        Question qst2_1_6 = new Question(21, "Koks tai žodis?", R.drawable.gele, 1, 2, "GĖLĖ", "LAPĖ", "SAGA", 1 );
        Question qst2_1_7 = new Question(22, "Koks tai žodis?", R.drawable.lele, 1, 2, "LAPĖ", "MAMA", "LĖLĖ", 3 );
        Question qst2_1_8 = new Question(23, "Koks tai žodis?", R.drawable.ozka, 1, 2, "OŽKA", "AVIS", "PELĖ", 1 );
        Question qst2_1_9 = new Question(44, "Koks tai žodis?", R.drawable.kede, 1, 2, "KĖDĖ", "GELĖ", "PELĖ", 1 );
        Question qst2_1_10 = new Question(45, "Koks tai žodis?", R.drawable.kede, 1, 2, "KĖDĖ", "GELĖ", "PELĖ", 1 );
        qstList.add(qst2_1_1);
        qstList.add(qst2_1_2);
        qstList.add(qst2_1_3);
        qstList.add(qst2_1_4);
        qstList.add(qst2_1_5);
        qstList.add(qst2_1_6);
        qstList.add(qst2_1_7);
        qstList.add(qst2_1_8);
        qstList.add(qst2_1_9);
        qstList.add(qst2_1_10);


        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType2Lvl2(int quant) {
        List<Question> qstList = new ArrayList<>();
        Question qst2_2_1 = new Question(46, "Koks tai žodis?", R.drawable.arklys, 2, 2, "ARKLYS", "AKMUO", "ANTIS", 1);
        Question qst2_2_2 = new Question(47, "Koks tai žodis?", R.drawable.braske, 2, 2, "BANKAS", "BRAŠKĖ", "BALDAS", 2 );
        Question qst2_2_3 = new Question(48, "Koks tai žodis?", R.drawable.dramblys, 2, 2, "DUONA", "DRAMBLYS", "DANTIS", 2 );
        Question qst2_2_4 = new Question(49, "Koks tai žodis?", R.drawable.kelnes, 2, 2, "KIEMAS", "KALNAS", "KELNĖS", 3 );
        Question qst2_2_5 = new Question(50, "Koks tai žodis?", R.drawable.knyga, 2, 2, "KNYGA", "KELNĖS", "KALNAS", 1 );
        Question qst2_2_6 = new Question(51, "Koks tai žodis?", R.drawable.meska, 2, 2, "MOLIS", "MEDUS", "MEŠKA", 3 );
        Question qst2_2_7 = new Question(52, "Koks tai žodis?", R.drawable.puodas, 2, 2, "PONAS", "PUODAS", "PELKĖ", 2 );
        Question qst2_2_8 = new Question(53, "Koks tai žodis?", R.drawable.ryklys, 2, 2, "RYKLYS", "ROJUS", "RAIDĖ", 1 );
        Question qst2_2_9 = new Question(54, "Koks tai žodis?", R.drawable.spurga, 2, 2, "SAULĖ", "SAGTIS", "SPURGA", 3 );
        Question qst2_2_10 = new Question(55, "Koks tai žodis?", R.drawable.suris, 2, 2, "SAULĖ", "SŪRIS", "SIENA", 2 );
        qstList.add(qst2_2_1);
        qstList.add(qst2_2_2);
        qstList.add(qst2_2_3);
        qstList.add(qst2_2_4);
        qstList.add(qst2_2_5);
        qstList.add(qst2_2_6);
        qstList.add(qst2_2_7);
        qstList.add(qst2_2_8);
        qstList.add(qst2_2_9);
        qstList.add(qst2_2_10);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType2Lvl3(int quant) {
        List<Question> qstList = new ArrayList<>();
        Question qst2_3_1 = new Question(56, "Koks tai žodis?", R.drawable.dviratis, 3, 2, "DVIRATIS", "DRAMBLYS", "DIREKTORIUS", 1);
        Question qst2_3_2 = new Question(57, "Koks tai žodis?", R.drawable.masina, 3, 2, "MAKARONAI", "MASINA", "MAGNETAS", 2 );
        Question qst2_3_3 = new Question(58, "Koks tai žodis?", R.drawable.laumzirgis, 3, 2, "LAIPTINĖ", "LAUMŽIRGIS", "LAIKRODIS", 2 );
        Question qst2_3_4 = new Question(59, "Koks tai žodis?", R.drawable.penkibalionai, 3, 2, "BANDELĖ", "BANANAI", "BALIONAI", 3 );
        Question qst2_3_5 = new Question(60, "Koks tai žodis?", R.drawable.bananaitrys, 3, 2, "BANANAI", "BANDELĖ", "BALIONAI", 1 );
        Question qst2_3_6 = new Question(61, "Koks tai žodis?", R.drawable.apelsinas, 3, 2, "AGURKAS", "AUGINTINIS", "APELSINAS", 3 );
        Question qst2_3_7 = new Question(62, "Koks tai žodis?", R.drawable.arbuzas, 3, 2, "APELSINAS", "ARBŪZAS", "AGURKAS", 2 );
        Question qst2_3_8 = new Question(63, "Koks tai žodis?", R.drawable.pingvinas, 3, 2, "PINGVINAS", "PIPIRAS", "PYRAGAS", 1 );
        Question qst2_3_9 = new Question(64, "Koks tai žodis?", R.drawable.saldainis, 3, 2, "SLIBINAS", "SAKALAS", "SALDAINIS", 3 );
        Question qst2_3_10 = new Question(65, "Koks tai žodis?", R.drawable.zirafa, 3, 2, "ŽUVĖDRA", "ŽIRAFA", "ŽODYNAS", 2 );
        qstList.add(qst2_3_1);
        qstList.add(qst2_3_2);
        qstList.add(qst2_3_3);
        qstList.add(qst2_3_4);
        qstList.add(qst2_3_5);
        qstList.add(qst2_3_6);
        qstList.add(qst2_3_7);
        qstList.add(qst2_3_8);
        qstList.add(qst2_3_9);
        qstList.add(qst2_3_10);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType3Lvl1(int quant) {
        List<Question> qstList = new ArrayList<>();
        Question qst3_1_1 = new Question(66, "Kokios spalvos varpas?", R.drawable.geltonasvarpas, 1, 3, "GELTONA", "RAUDONA", "MĖLYNA", 1);
        Question qst3_1_2 = new Question(67, "Kokios spalvos šuo?", R.drawable.juodassuo, 1, 3, "RAUDONA", "JUODA", "GELTONA", 2 );
        Question qst3_1_3 = new Question(68, "Kokios spalvos masina?", R.drawable.melynamasina, 1, 3, "ŽALIA", "MĖLYNA", "BALTA", 2 );
        Question qst3_1_4 = new Question(69, "Kokios kokios spalvos suknelė?", R.drawable.princese, 1, 3, "JUODA", "GELTONA", "ROŽINĖ", 3 );
        Question qst3_1_5 = new Question(70, "Kokios spalvos masina?", R.drawable.raudonamasina, 1, 3, "RAUDONA", "ŽALIA", "MĖLYNA", 1 );
        Question qst3_1_6 = new Question(71, "Kokios spalvos tigras?", R.drawable.tigras, 1, 3, "JUODA", "RAUDONA", "ORANŽINĖ", 3 );
        Question qst3_1_7 = new Question(72, "Kokios spalvos mašina?", R.drawable.zaliamasina, 1, 3, "GELTONA", "ŽALIA", "MĖLYNA", 2 );
        Question qst3_1_8 = new Question(73, "Kokios spalvos apelsinas?", R.drawable.apelsinas, 1, 3, "ORANŽINĖ", "ŽALIA", "RAUDONA", 1 );
        Question qst3_1_9 = new Question(74, "Kokios spalvos avis?", R.drawable.avis, 1, 3, "PILKA", "JUODA", "BALTA", 3 );
        Question qst3_1_10 = new Question(75, "Kokios slapvos gėlė?", R.drawable.gele, 1, 3, "MĖLYNA", "VIOLETINĖ", "ORANŽINĖ", 2 );
        qstList.add(qst3_1_1);
        qstList.add(qst3_1_2);
        qstList.add(qst3_1_3);
        qstList.add(qst3_1_4);
        qstList.add(qst3_1_5);
        qstList.add(qst3_1_6);
        qstList.add(qst3_1_7);
        qstList.add(qst3_1_8);
        qstList.add(qst3_1_9);
        qstList.add(qst3_1_10);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType3Lvl2(int quant) {
        List<Question> qstList = new ArrayList<>();
        Question qst3_2_1 = new Question(76, "Kokių spalvų bitės kūnas?", R.drawable.bite, 2, 3, "GELTONA IR JUODA", "RAUDONA IR BALTA", "MĖLYNA IR RAUDONA", 1);
        Question qst3_2_2 = new Question(77, "Kokių spalvų tigro kailis?", R.drawable.tigras, 2, 3, "JUODA IR MĖLYNA", "ORANŽINĖ IR JUODA", "JUODA IR GELTONA", 2 );
        Question qst3_2_3 = new Question(78, "Kokių spalvų saldainio popierėlis?", R.drawable.saldainis, 2, 3, "BALTA IR ROŽINĖ", "BALTA IR MĖLYNA", "BALTA IR ŽALIA", 1 );
        Question qst3_2_4 = new Question(79, "Kokių spalvos arbūzo vidus ir žievė?", R.drawable.arbuzas, 2, 3, "RAUDONA IR JUODA", "ŽALIA IR GELTONA", "ŽALIA IR RAUDONA", 3 );
        Question qst3_2_5 = new Question(80, "Kokių spalvų panda?", R.drawable.panda, 2, 3, "JUODA IR BALTA", "JUODA IR RAUDONA", "BALTA IR MĖLYNA", 1 );
        Question qst3_2_6 = new Question(81, "Kokių spalvų puodas ir dangtis", R.drawable.puodas, 2, 3, "ŽYDRA IR GELTONA", "RAUDONA IR ŽALIA", "ŽYDRA IR RAUDONA", 3 );
        Question qst3_2_7 = new Question(82, "Kokių spalvos medžio kamienas ir lapai?", R.drawable.medis, 2, 3, "RUDA IR ŽALIA", "ŽALIA IR RAUDONA", "MĖLYNA IR RUDA", 1 );
        Question qst3_2_8 = new Question(83, "Kokių spalvų žirklės?", R.drawable.zirkles, 2, 3, "PILKA IR VIOLETINĖ", "PILKA IR RUDA", "RAUDONA IR PILKA", 1 );
        Question qst3_2_9 = new Question(84, "Kokių spalvų knygos?", R.drawable.knygosdvi, 2, 3, "ŽALIA IR GELTONA", "JUODA IR PILKA", "ŽALIA IR MĖLYNA", 3 );
        Question qst3_2_10 = new Question(85, "Kokių spalvų delfinai?", R.drawable.delfinaidu, 2, 3, "MĖLYNA IR GELTONA", "MĖLYNA IR PILKA", "PILKA IR ŽALIA", 2 );
        qstList.add(qst3_2_1);
        qstList.add(qst3_2_2);
        qstList.add(qst3_2_3);
        qstList.add(qst3_2_4);
        qstList.add(qst3_2_5);
        qstList.add(qst3_2_6);
        qstList.add(qst3_2_7);
        qstList.add(qst3_2_8);
        qstList.add(qst3_2_9);
        qstList.add(qst3_2_10);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

    public static List<Question> getType3Lvl3(int quant) {
        List<Question> qstList = new ArrayList<>();
        Question qst3_3_1 = new Question(86, "Kiek matai spalvų?", R.drawable.grybaitrys, 3, 3, "4", "3", "5", 1);
        Question qst3_3_2 = new Question(87, "Kiek matai spalvų?", R.drawable.balionaitrys, 3, 3, "2", "3", "4", 2 );
        Question qst3_3_3 = new Question(88, "Kiek matai spalvų?", R.drawable.trysledai, 3, 3, "8", "6", "9", 1 );
        Question qst3_3_4 = new Question(89, "Kiek matai spalvų?", R.drawable.gelestrys, 3, 3, "3", "4", "5", 3 );
        Question qst3_3_5 = new Question(90, "Kiek matai spalvų?", R.drawable.penkibalionai, 3, 3, "3", "4", "5", 2 );
        Question qst3_3_6 = new Question(91, "Kiek matai spalvų?", R.drawable.sesiosspurgos, 3, 3, "3", "4", "5", 1 );
        Question qst3_3_7 = new Question(92, "Kiek matai spalvų?", R.drawable.sesioszvaigzdes, 3, 3, "3", "6", "5", 2 );
        Question qst3_3_8 = new Question(93, "Kiek matai spalvų?", R.drawable.dvylikapiestuku, 3, 3, "11", "12", "12", 2 );
        Question qst3_3_9 = new Question(94, "Kiek matai spalvų?", R.drawable.lape, 3, 3, "3", "4", "5", 1 );
        Question qst3_3_10 = new Question(95, "Kiek matai spalvų?", R.drawable.balionaitrys, 3, 3, "3", "4", "5", 1 );
        qstList.add(qst3_3_1);
        qstList.add(qst3_3_2);
        qstList.add(qst3_3_3);
        qstList.add(qst3_3_4);

        List<Question> returList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quant; i++) {
            int randomIndex = rand.nextInt(qstList.size());
            returList.add(qstList.get(randomIndex));
            qstList.remove(randomIndex);
        }
        return returList;
    }

}
