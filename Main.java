package taskManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<TarefasData> datas = AcessoDados.leArquivo("files/animais.csv");

        System.out.println("");
        System.out.println("No teste animais");

        for(TarefasData data: datas){
            System.out.println(data);
        }

        datas.add(new TarefasData(0, 0, 0));
        //animais.add(new Animal("francis", 7, 2));

        System.out.println("");
        //System.out.println("No teste animais depois de incluir um animal novo");

        for(TarefasData data: datas){
            System.out.println(data);
        }

       /* for(int i=0; i<datas.size(); i++){
        	TarefasData data = datas.get(i);
            if(data.getDataDia().equals()){
                datas.remove(i);
                break;
            }
        }*/

        System.out.println("");
        System.out.println("No teste animais depois de retirar o vacilo");

     //   AcessoDados.saveArquivo(datas, "files/animais.csv");



    }

}