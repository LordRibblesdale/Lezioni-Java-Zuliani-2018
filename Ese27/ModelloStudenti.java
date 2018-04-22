import javax.swing.table.AbstractTableModel;

public class ModelloStudenti extends AbstractTableModel {
   private String[] n = {"Nome", "Cognome", "Matricola", "Media", "Esami"};
   private Object[][] s;

   ModelloStudenti(Studente[] s) {
      this.s = new Object[s.length][n.length];
      for (int i = 0; i < s.length; i++) {
            this.s[i][0] = s[i].getNome();
            this.s[i][1] = s[i].getCognome();
            this.s[i][2] = new Integer(s[i].getMatricola());
            this.s[i][3] = new Integer(s[i].getMediaVoti());
            this.s[i][4] = new Integer(s[i].getEsamiVerbalizzati());
      }
   }

   public int getRowCount() {
      return s.length;
   }

   public int getColumnCount() {
      return n.length;
   }

   public String getColumnName(int column) {
      return n[column];
   }

   public Object getValueAt(int rowIndex, int columnIndex) {
      return s[rowIndex][columnIndex];
   }

   public Class<?> getColumnClass(int rowIndex, int columnIndex) {
      return getValueAt(rowIndex, columnIndex).getClass();
   }

   public void addStudent(Studente st) {
      Object[][] newS = new Object[this.s.length+1][n.length];
      for (int i = 0; i < newS.length; i++) {
         if (i != newS.length-1) {
            newS[i][0] = s[i][0];
            newS[i][1] = s[i][1];
            newS[i][2] = s[i][2];
            newS[i][3] = s[i][3];
            newS[i][4] = s[i][4];
         } else {
            newS[i][0] = st.getNome();
            newS[i][1] = st.getCognome();
            newS[i][2] = new Integer(st.getMatricola());
            newS[i][3] = new Integer(st.getMediaVoti());
            newS[i][4] = new Integer(st.getEsamiVerbalizzati());
         }
      }
      this.s = newS;
   }
}
