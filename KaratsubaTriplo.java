public class KaratsubaTriplo {

    public static String resultString = "";
    public static int resultMult = 0;

    public static void karaTriplo(String values) {
        String a = values.split("x")[0];
        String b = values.split("x")[1];
        String shift1 = "0";
        String shift2 = "0";

        // Chama o método recursivo
        //System.out.println(karaTriploRec(a, b, shift1, shift2));
        karaTriploRec(a, b, shift1, shift2, "0");
    }

    private static String karaTriploRec(String a, String b, String shift1, String shift2, String soma) {
        System.out.println("Entrada: " + a + " " + b + " shifts: " + shift1 + " " + shift2);
        if (a.length() == 1 && b.length() == 1) {
            int auxA = Integer.parseInt(a);
            int auxB = Integer.parseInt(b);
            String result = Integer.toString(auxA * auxB);
            for(int i = 0; i < (Integer.parseInt(shift1)+Integer.parseInt(shift2)); i++){
                result += "0";
            }

            System.out.println(result);
            resultString += Integer.toString(auxA * auxB) + " x 10^" + shift1 + " x 10^" + shift2 + " \n";
            return result;
        }

        // Trata o tamanho dos valores para que tenham no mínimo 3 dígitos sempre
        if (a.length() < 3) {
            if (a.length() == 1)
                a = "00" + a;
            if (a.length() == 2)
                a = "0" + a;
        }

        if (b.length() < 3) {
            if (b.length() == 1)
                b = "00" + b;
            if (b.length() == 2)
                b = "0" + b;
        }

        // System.out.println("Ajustes: " + a +" "+ b);

        // Quebra o a em 3 partes
        int aux = a.length() / 3;
        String a1 = a.substring(0, aux);
        String a2 = a.substring(aux, 2 * aux);
        String a3 = a.substring(2 * aux);

        // Quebra o b em 3 partes
        int aux2 = a.length() / 3;
        String b1 = b.substring(0, aux2);
        String b2 = b.substring(aux2, 2 * aux2);
        String b3 = b.substring(2 * aux2);

        // Shifts
        int sa1 = a.length() - a1.length();
        int sa2 = a.length() - (2 * a2.length());
        int sa3 = a.length() - (2 * a2.length() + b3.length());

        System.out.println("shift a: " + sa1 + " " + sa2 + " " + sa3);

        int sb1 = b.length() - b1.length();
        int sb2 = b.length() - (2 * b1.length());
        int sb3 = b.length() - (2 * b1.length() + b3.length());

        System.out.println("shift b: " + sb1 + " " + sb2 + " " + sb3);

        // System.out.println("Novos valores: ");
        // System.out.println("a1: " + a1 + " " + sa1);
        // System.out.println("a2: " + a2 + " " + sa2);
        // System.out.println("a3: " + a3 + " " + sa3);

        // System.out.println("b1: " + b1 + " " + sb1);
        // System.out.println("b2: " + b2 + " " + sb2);
        // System.out.println("b3: " + b3 + " " + sb3);

        //if (Integer.parseInt(a1) != 0 && Integer.parseInt(b1) != 0) {
            String A = karaTriploRec(a1, b1, Integer.toString(sa1), Integer.toString(sb1));
            String B = karaTriploRec(a1, b2, Integer.toString(sa1), Integer.toString(sb2));
            String C = karaTriploRec(a1, b3, Integer.toString(sa1), Integer.toString(sb3));
            // String sum1 = sum(karaTriploRec(a1, b1, Integer.toString(sa1), Integer.toString(sb1)), karaTriploRec(a1, b2, Integer.toString(sa1), Integer.toString(sb2)));
            //sum1 = sum(sum1, karaTriploRec(a1, b3, Integer.toString(sa1), Integer.toString(sb3)));
            System.out.println(sum(C, B));
            System.out.println(("A:" + A + " B:" + B + " C: " + C));
        //}
        //if (Integer.parseInt(a1) != 0 && Integer.parseInt(b2) != 0) {
            //String resultA1b = karaTriploRec(a1, b2, Integer.toString(sa1), Integer.toString(sb2));
        
        //if (Integer.parseInt(a1) != 0 && Integer.parseInt(b3) != 0) {
            //String resultA1c = karaTriploRec(a1, b3, Integer.toString(sa1), Integer.toString(sb3));
        
        //if (Integer.parseInt(a2) != 0 && Integer.parseInt(b1) != 0) {
            String sum2 = sum(karaTriploRec(a2, b1, Integer.toString(sa2), Integer.toString(sb1)), karaTriploRec(a2, b2, Integer.toString(sa2), Integer.toString(sb2)));
            sum2 = sum(sum2, karaTriploRec(a2, b3, Integer.toString(sa2), Integer.toString(sb3)));
            //System.out.println(("SUM2:" + sum2));
            //}
        //if (Integer.parseInt(a2) != 0 && Integer.parseInt(b2) != 0) {
            //String resultA2b =karaTriploRec(a2, b2, Integer.toString(sa2), Integer.toString(sb2));
        //}
        //if (Integer.parseInt(a2) != 0 && Integer.parseInt(b3) != 0) {
            //String resultA2c = karaTriploRec(a2, b3, Integer.toString(sa2), Integer.toString(sb3));
        //}
        //if (Integer.parseInt(a3) != 0 && Integer.parseInt(b1) != 0) {
            String sum3 = sum(karaTriploRec(a3, b1, Integer.toString(sa3), Integer.toString(sb1)),karaTriploRec(a3, b2, Integer.toString(sa3), Integer.toString(sb2)));
            //System.out.println(("SUM3:" + sum3));
            sum3 = sum(sum3, karaTriploRec(a3, b3, Integer.toString(sa3), Integer.toString(sb3)));
            
        //}
        //if (Integer.parseInt(a3) != 0 && Integer.parseInt(b2) != 0) {
            //String resultA3b = karaTriploRec(a3, b2, Integer.toString(sa3), Integer.toString(sb2));
        //}
        //if (Integer.parseInt(a3) != 0 && Integer.parseInt(b3) != 0) {
            //String resultA3c = karaTriploRec(a3, b3, Integer.toString(sa3), Integer.toString(sb3));
        //}

        return "A: "  + " B: " + sum2 + " C: " + sum3;
    }

    public static void printResult() {
         //System.out.println(resultString);
        // System.out.println(resultMult);
    }

    static String sum(String v1, String v2) {

        //coloca o valor maior no v2 caso v1 seja maior
        if (v1.length() > v2.length()) {
            String aux = v1;
            v1 = v2;
            v2 = aux;
        }

        String result = "";
        int size1 = v1.length();
        int size2 = v2.length();
        
        v1 = new StringBuilder(v1).reverse().toString();
        v2 = new StringBuilder(v2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < size1; i++) {
            int sum = ((int) (v1.charAt(i) - '0') +
                    (int) (v2.charAt(i) - '0') + carry);
            result += (char) (sum % 10 + '0');

            carry = sum / 10;
        }

        for (int i = size1; i < size2; i++) {
            int sum = ((int) (v2.charAt(i) - '0') + carry);
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0)
            result += (char) (carry + '0');

        result = new StringBuilder(result).reverse().toString();

        return result;
    }
}
