package taskManager;

public class TarefasData {
	 private int dataDia;
	 private int dataMes;
	 private int dataAno;
	 private int idData;
		
	 public TarefasData(int dataDia, int dataMes, int dataAno, int idData) {
	  super();
	 
	  this.dataDia = dataDia;
	  this.dataMes = dataMes;
	  this.dataAno = dataAno;
	  this.idData = idData;
	 }
	 public static TarefasData createNewData(int dataDia, int dataMes, int dataAno, int idData) {
			return new TarefasData(dataDia,dataMes,dataAno, idData);
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
	 
	 public int getIdData() {
			return idData;
		}
		public void setIdData(int idData) {
			this.idData = idData;
		}
	 
	  @Override
			public String toString() {
				return  dataDia + "," + dataMes + "," + dataAno + "," + idData;
			}
	
	}
