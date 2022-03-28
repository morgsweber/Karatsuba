 /*  PROJETO E OTIMIZAÇÃO DE ALGORITMOS
    Prof. João Batista
    Turma 010
    Morgana Weber
    Trabalho Prático 1
*/

public class KaratsubaTriplo {

    public static String karaTriplo(String values) {
        String a = values.split(" ")[0];
        String b = values.split(" ")[1];
        String shift1 = "0";
        String shift2 = "0";

        // Chama o método recursivo
        return  karaTriploRec(a, b, shift1, shift2, 0);
    }

    private static String karaTriploRec(String a, String b, String shift1, String shift2, int auxSum) {
        if (a.length() == 1 && b.length() == 1) {
            int auxA = Integer.parseInt(a);
            int auxB = Integer.parseInt(b);
            String result = Integer.toString(auxA * auxB);
             for (int i = 0; i < Integer.parseInt(shift1)+Integer.parseInt(shift2); i++) {
                 result += "0";
             }

            return result;
        } else {
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

            // Quebra o a em 3 partes
            int aux = a.length() / 3;
            String a1 = a.substring(0, aux);
            String a2 = a.substring(aux, 2 * aux);
            String a3 = a.substring(2 * aux);

            // Quebra o b em 3 partes
            int aux2 = b.length() / 3;
            String b1 = b.substring(0, aux2);
            String b2 = b.substring(aux2, 2 * aux2);
            String b3 = b.substring(2 * aux2);

            // Shifts
            int sa1 = Integer.parseInt(shift1) + a.length() - a1.length();
            int sa2 = Integer.parseInt(shift1) + a.length() - (2 * a1.length());
            int sa3 = Integer.parseInt(shift1) + a.length() - (2 * a1.length() + a3.length());

            int sb1 = Integer.parseInt(shift2) + b.length() - b1.length();
            int sb2 = Integer.parseInt(shift2) + b.length() - (2 * b1.length());
            int sb3 = Integer.parseInt(shift2) + b.length() - (2 * b1.length() + b3.length());

            String s1 = karaTriploRec(a1, b1, Integer.toString(sa1), Integer.toString(sb1), 6)+"";
            String s2 = karaTriploRec(a1, b2, Integer.toString(sa1), Integer.toString(sb2), 5);
            String s3 = karaTriploRec(a1, b3, Integer.toString(sa1), Integer.toString(sb3), 3);
            String s4 = karaTriploRec(a2, b1, Integer.toString(sa2), Integer.toString(sb1), 5);
            String s5 = karaTriploRec(a2, b2, Integer.toString(sa2), Integer.toString(sb2), 4);
            String s6 = karaTriploRec(a2, b3, Integer.toString(sa2), Integer.toString(sb3), 2);
            String s7 = karaTriploRec(a3, b1, Integer.toString(sa3), Integer.toString(sb1), 3);
            String s8 = karaTriploRec(a3, b2, Integer.toString(sa3), Integer.toString(sb2), 2);
            String s9 = karaTriploRec(a3, b3, Integer.toString(sa3), Integer.toString(sb3), 0);

            String result = sum(s9, s8);
            result = sum(result, s7);
            result = sum(result, s6);
            result = sum(result, s5);
            result = sum(result, s4);
            result = sum(result, s3);
            result = sum(result, s2);
            result = sum(result, s1);

            return result;
        }

    }

    static String sum(String v1, String v2) {

        // coloca o valor maior no v2 caso v1 seja maior
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
            int sum = ((int) (v1.charAt(i) - '0') + (int) (v2.charAt(i) - '0') + carry);
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
