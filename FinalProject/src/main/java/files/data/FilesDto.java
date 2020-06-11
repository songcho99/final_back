package files.data;

public class FilesDto {
	private int files_num;
	private int files_tables_num;
	private int files_tables_boardtype;
	private String files_tables_filename;
	
	public int getFiles_num() {
		return files_num;
	}
	public void setFiles_num(int files_num) {
		this.files_num = files_num;
	}
	public int getFiles_tables_num() {
		return files_tables_num;
	}
	public void setFiles_tables_num(int files_tables_num) {
		this.files_tables_num = files_tables_num;
	}
	public int getFiles_tables_boardtype() {
		return files_tables_boardtype;
	}
	public void setFiles_tables_boardtype(int files_tables_boardtype) {
		this.files_tables_boardtype = files_tables_boardtype;
	}
	public String getFiles_tables_filename() {
		return files_tables_filename;
	}
	public void setFiles_tables_filename(String files_tables_filename) {
		this.files_tables_filename = files_tables_filename;
	}
	
	@Override
	public String toString() {
		return "FilesDto [files_num=" + files_num + ", files_tables_num=" + files_tables_num
				+ ", files_tables_boardtype=" + files_tables_boardtype + ", files_tables_filename="
				+ files_tables_filename + "]";
	}
	
}
