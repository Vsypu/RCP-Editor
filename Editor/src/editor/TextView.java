package editor;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.FileDialog;


public class TextView extends ViewPart {
	
	public static final String ID = "Editor.view1";
	
	public Text text;
	Shell parent;
	
	@Override
	public void createPartControl(Composite parent) {
		
		this.parent = parent.getShell();
			
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		text = new Text(parent, SWT.MULTI |SWT.BORDER |SWT.WRAP);   
		text.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));			        	         	
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}	
	
	public void setTitle(String s)
	{
		setPartName(s);
	}
	
	public void readFile() {
		FileDialog dlg = new FileDialog(parent, SWT.OPEN);	
	    String fname = dlg.open();
	    if(fname != null) {
	    try (BufferedReader br = new BufferedReader(new FileReader(fname));) {			    		
				String readed;
				ArrayList<String> read = new ArrayList<String>();
				while((readed = br.readLine()) != null) {	
					
							read.add(readed + "\n");
				    	   text.setText(read.toString().replaceAll("^\\[|\\]$", "").replace(",", ""));		    	   
				    	}				               
		            } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		          		    			       
	    };
	}
	
	public void saveFile() {
		
		FileDialog dlg = new FileDialog(parent, SWT.SAVE);		
		String fname = dlg.open();
		if (fname != null)
		    System.out.println ("" + fname);
	}
}
