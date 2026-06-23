package vigesissexagesimal;

// esse array é usado para preencher os arquivos de página, garantindo que cada arquivo tenha um conteúdo único, funciona como uma base 
// numérica vigesissexagesimal (26 letras do alfabeto), semelhante ao binário só que baseado no alfabeto ascii
public class Vigesissexagesimal {
    private int[] caracteres;

    public Vigesissexagesimal(){
        caracteres = new int[10]; // 10 caracteres para garantir 26^10 combinações únicas, o que é mais do que suficiente para os arquivos de página
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = 97;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < caracteres.length; i++) {
            sb.append((char) caracteres[i]);
        }
        return sb.toString();
    }

    public void incrementa() {
        for (int i = caracteres.length - 1; i >= 0; i--) {
            if (caracteres[i] < 122) { // 'z' em ASCII
                caracteres[i]++;
                break;
            } else {
                caracteres[i] = 97; // volta para 'a'
            }
        }
    }
}
