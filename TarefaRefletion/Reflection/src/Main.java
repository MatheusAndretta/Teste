import java.lang.annotation.Annotation;

public class Main {

    
        public static void main(String[] args) {
            Class<?> clazz = ClasseComAnotacao.class;

            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof TabelaAnotation) {
                    TabelaAnotation tabelaAnotation = (TabelaAnotation) annotation;
                    System.out.println("Nome da anotação é : " + tabelaAnotation.nome());
                }
            }
        }
    }

