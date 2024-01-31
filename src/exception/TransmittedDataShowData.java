package exception;

public class TransmittedDataShowData {
    private String typeData;
    private String backToPage;
    private int tourId;
    private int teacherId;
    private int studentId;
    private boolean isStudent;
    
    public TransmittedDataShowData() {
    }
    
    public TransmittedDataShowData(String typeData, String backToPage, int tourId, int Id, boolean isStudent ) {
        this.typeData = typeData;
        this.backToPage = backToPage;
        this.tourId = tourId;
        this.isStudent = isStudent;
        if(isStudent) this.studentId  = Id;
        else this.teacherId = Id;
    }
    
    public TransmittedDataShowData(String typeData, String backToPage,int Id, boolean isStudent ) {
        this.typeData = typeData;
        this.backToPage = backToPage;
        this.isStudent = isStudent;
        if(isStudent) this.studentId  = Id;
        else this.teacherId = Id;
    }

    public TransmittedDataShowData(String typeData, String backToPage) {
        this.typeData = typeData;
        this.backToPage = backToPage;
    }

    public void setTypeData(String typeData) {
        this.typeData = typeData;
    }

    public void setBackToPage(String backToPage) {
        this.backToPage = backToPage;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }
    
    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTypeData() {
        return typeData;
    }

    public String getBackToPage() {
        return backToPage;
    }

    public int getTourId() {
        return tourId;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
