	package programaestudiante2023;
	import java.util.*;
	import javax.swing.*;
	import java.io.*;
	
	public class Estudiantes2023 {
	    private static ArrayList<Estudiante> estudiantes;
	
	    public Estudiantes2023() {
	        estudiantes = new ArrayList<>();
	        cargarArchivo();
	    }
	
	    public void adicionar(Estudiante estudiante) 
	    {
	    	estudiantes.add(estudiante);
	    }
	
	    public void eliminar(Estudiante estudiante) 
	    {
	        estudiantes.remove(estudiante);
	    }
	
	    public void modificarApellidosAMinusculas() {
	        for (Estudiante estudiante : estudiantes) {
	            String nombreCompleto = estudiante.getNombre();
	            String[] partesNombre = nombreCompleto.split(" ");
	            
	            if (partesNombre.length >= 2) {
	                String nuevoApellido = partesNombre[1].toLowerCase();
	                partesNombre[1] = nuevoApellido;
	                estudiante.setNombre(String.join(" ", partesNombre));
	            }
	        }
	    }
	    public Estudiante obtenerEstudiante(int pos) 
	    {
	    	return estudiantes.get(pos);
	    }
	    
	    public ArrayList<Estudiante> obtenerTodosEstudiantes() 
	    {
	    	return estudiantes;
	    }
	    
	    public int obtenerUltimoCodigo() 
	    {
	    	int ultimo = estudiantes.size() - 1;
	    	Estudiante ultimoEstudiante = estudiantes.get(ultimo);
	    	return ultimoEstudiante.getCodigo();
	    }
	    
	    public String buscarNombre(String nombre)
	    {
	    	int contador = 0;
	    	boolean salirBucle = false;
	    	
	    	String resultado = new String();
	    	
	    	while (salirBucle == false)
	    	{
	    		
	    		if(nombre.equals(this.obtenerEstudiante(contador).getNombre()))
	    		{
	    			System.out.println("ESTUDIANTE ENCONTRADO");
	    			resultado = this.obtenerEstudiante(contador).toString();
	    			salirBucle = true;
	    		}
	    		
	    		if(contador == (this.tamano() - 1))
	        	{
	        		resultado = "ESTUDIANTE NO REGISTRADO";
	        		salirBucle = true;
	        	}
	    		
	    		contador++;
	    	}
	    	
	    	return resultado;
	    }
	    
	    public String buscarCodigo(int codigo)
	    {
	    	int contador = 0;
	    	boolean salirBucle = false;
	    	
	    	String resultado = new String();
	    	
	    	while (salirBucle == false)
	    	{
	    		
	    		if(codigo == this.obtenerEstudiante(contador).getCodigo())
	    		{
	    			System.out.println("ESTUDIANTE ENCONTRADO");
	    			resultado = this.obtenerEstudiante(contador).toString();
	    			salirBucle = true;
	    		}
	    		
	    		if(contador == (this.tamano() - 1))
	        	{
	        		resultado = "ESTUDIANTE NO REGISTRADO";
	        		salirBucle = true;
	        	}
	    		
	    		contador++;
	    	}
	    	
	    	return resultado;
	    }
	
	    public int tamano()
	    {
		  return estudiantes.size();
	    }
	
	    public void listarEstudiantes()
	    {
	    	System.out.println("Codigo    ciclo      Nombre                              Pension");
	    	System.out.println("----------------------------------------------------------------------- ");
	    	
	    	for(Estudiante estudiante : estudiantes)
			{
	    		System.out.println(estudiante.toString());
	    		System.out.println();
			}
	    	
	    	System.out.println("----------------------------------------------------------------------- \n");
	    }
	
	    public void verEstudiantesPorApellidos() {
	            Collections.sort(estudiantes, new Comparator<Estudiante>() {
	                @Override
	                public int compare(Estudiante e1, Estudiante e2) {
	                    String ap1 = e1.getNombre().split(" ")[1]; 
	                    String ap2 = e2.getNombre().split(" ")[1]; 
	                    return ap1.compareTo(ap2);
	                }
	            });
	            
	            System.out.println("Codigo    Ciclo  Apellido           Pension");
	            System.out.println("----------------------------------------");
	            
	            for (Estudiante estudiante : estudiantes) {
	                String[] nombreCompleto = estudiante.getNombre().split(" ");
	                int codigo = estudiante.getCodigo();
	                int ciclo = estudiante.getCiclo();
	                String apellido = nombreCompleto[1]; // Obtener el segundo elemento como apellido
	                double pension = estudiante.getPension();
	                
	                System.out.format("%-9s %-6s %-18s %-10.2f%n", codigo, ciclo, apellido, pension);
	            }
	            
	            System.out.println("\n");
	        }
	
	     
	   
	
	
	    // M?todos para manipular el archivo de texto
	    private void readFromInputStream(InputStream inputStream) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            StringTokenizer st = new StringTokenizer(linea, ",");
	            createStudent(st);
	        }
	        br.close();
	    }
	
		// M?todo que a?adir a los estudiantes del archivo .txt en el arrayList estudiantes.
	    private void createStudent(StringTokenizer st){
	        int codigo = Integer.parseInt(st.nextToken().trim());
	        String nombre = st.nextToken().trim();
	        int ciclo = Integer.parseInt(st.nextToken().trim());
	        double pension = Double.parseDouble(st.nextToken().trim());
	        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
	        adicionar(estudiante);
	    }
	
	    // M?todos para manipular el archivo de texto
	    private void cargarArchivo() {
	        try {
	            File file = new File("./src/estudiantes.txt");
	            Class<Estudiantes2023> clazz = Estudiantes2023.class;
	            InputStream inputStream = clazz.getResourceAsStream("/estudiantes.txt");
	            if (file.exists()) {
	                readFromInputStream(inputStream);
	            } else
	                JOptionPane.showMessageDialog(null,
	                        "El archivo estudiantes.txt no existe");
	        } catch (Exception x) {
	            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
	        }
	    }
	}
