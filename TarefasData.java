package taskManager;

public class TarefasData {
	 private int idData;
	 private int dataDia;
	 private int dataMes;
	 private int dataAno;
		
	 public TarefasData(int idData, int dataDia, int dataMes, int dataAno) {
	  super();
	  this.idData = idData;
	  this.dataDia = dataDia;
	  this.dataMes = dataMes;
	  this.dataAno = dataAno;
	 }
		
	 public int getIdData() {
		return idData;
	}

	public void setIdData(int idData) {
		this.idData = idData;
	}



	public int getDataDia() {
	  return dataDia;
	 }


	 public void setDataDia(int dataDia) {
	  this.dataDia = dataDia;
	 }


	 public int getDataMes() {
	  return dataMes;
	 }


	 public void setDataMes(int dataMes) {
	  this.dataMes = dataMes;
	 }


	 public int getDataAno() {
	  return dataAno;
	 }


	 public void setDataAno(int dataAno) {
	  this.dataAno = dataAno;
	 }
	}
