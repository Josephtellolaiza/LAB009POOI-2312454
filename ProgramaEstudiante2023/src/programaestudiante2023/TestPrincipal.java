package programaestudiante2023;

import java.util.Scanner;

public class TestPrincipal
{
	public static void main(String[] args) 
	{
		Estudiantes2023 estudiantes2023 = new Estudiantes2023();
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		boolean salirMenuPrincipal = false;
		
		Scanner entradaMenu = new Scanner(System.in);
		
		Scanner eNuevoNombre = new Scanner(System.in);
		Scanner eNuevoApellido = new Scanner(System.in);
		Scanner eNuevoCiclo = new Scanner(System.in);
		Scanner eNuevaPension = new Scanner(System.in);
		Scanner eRespuestaYN1 = new Scanner(System.in);

		Scanner eElegirAB = new Scanner(System.in);
		Scanner eNombreEstudianteBuscado = new Scanner(System.in);
		Scanner eCodigoEstudianteBuscado = new Scanner(System.in);

		Scanner eCodigoEstudianteEliminar = new Scanner(System.in);
		Scanner eRespuestaYN2 = new Scanner(System.in);
		
		Scanner eCodigoEstudianteModificar = new Scanner(System.in);
		Scanner eRespuestaYN3 = new Scanner(System.in);
		Scanner eRespuestaYN4 = new Scanner(System.in);
		Scanner eNombreModificado = new Scanner(System.in);
		Scanner eApellidoModificado = new Scanner(System.in);
		Scanner eCicloModificado = new Scanner(System.in);
		Scanner ePensionModificada = new Scanner(System.in);
		
		System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ******");
		
		do
		{
			System.out.println("1 - NUEVO ESTUDIANTE");
			System.out.println("2 - BUSCAR ESTUDIANTE");
			System.out.println("3 - ELIMINAR ESTUDIANTE");
			System.out.println("4 - MODIFICAR ESTUDIANTE");
			System.out.println("5 - MODIFICAR APELLIDOS EN MINUSCULAS");
			System.out.println("6 - VER TODOS LOS ESTUDIANTES");
			System.out.println("7 - VER TODOS LOS ESTUDIANTES POR APELLIDOS");
			System.out.println("8 - VER TODOS LOS ESTUDIANTES POR PENSION");
			System.out.println("9 - TOTAL DE PENSIONES");
			System.out.println("10 - SALIR");
			System.out.println("");
			System.out.println("");
			System.out.println("QUE ACTIVIDAD DESEA EJECUTAR?");
			
			int entradaInt = entradaMenu.nextInt();
			
			switch (entradaInt)
			{
				case 1:
				{
					boolean salirOpcion1 = false;
			
					String nuevoNombre = new String();
					String nuevoApellido = new String();
					String nuevoNombreCompleto = new String();
					String respuestaYN1 = new String();
					
					int nuevoCodigo, nuevoCiclo;
					double nuevaPension;
					
					System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ******");
					do
					{
						System.out.println("INGRESE NOMBRES: ");
						nuevoNombre = eNuevoNombre.next();
						
						System.out.println("INGRESE APELLIDOS: ");
						nuevoApellido = eNuevoApellido.next();
						
						System.out.println("INGRESE CICLO: ");
						nuevoCiclo = eNuevoCiclo.nextInt();
						
						System.out.println("INGRESE PENSION: ");
						nuevaPension = eNuevaPension.nextDouble();
						
						System.out.println("ESTOS DATOS SON CORRECTOS? Y/N");
						respuestaYN1 = eRespuestaYN1.next();
						
						if (respuestaYN1.equals("Y"))
						{
							nuevoNombreCompleto = nuevoNombre + " " + nuevoApellido;
							
							int ultimoCodigo = estudiantes2023.obtenerUltimoCodigo();
							nuevoCodigo = ultimoCodigo + 1;
							
							Estudiante nuevoEstudiante = new Estudiante(nuevoCodigo, nuevoNombreCompleto, nuevoCiclo, nuevaPension);
							estudiantes2023.adicionar(nuevoEstudiante);
							
							salirOpcion1 = true;
						}
						
						else if (respuestaYN1.equals("N"))
						{
							System.out.println("VUELVA A INGRESAR LOS DATOS");
						}
						
						else
						{
							System.out.println("RESPUESTA INVALIDA");
						}
					}
					while(salirOpcion1 == false);
					
					System.out.println("Se añadio con exito!");
					System.out.println("DESEA INGRESAR OTRA OPCION?");
					System.out.println("");
					System.out.println("");
					break;
				}
				
				case 2:
				{
					int codigoEstudianteBuscado;
					
					boolean salirMenuBuscar = false;
					
					String elegirAB = new String();
					String nombreEstudianteBuscado = new String();
					String resultado = new String();
					
					System.out.println("****** BUSCAR A UN ESTUDIANTE ******");
					
					System.out.println("PUEDE BUSCAR POR NOMBRE O CODIGO. ELEGIR UNA OPCIÓN:");
					do
					{
						System.out.println("A - APELLIDO");
						System.out.println("");
						System.out.println("B - CODIGO");
						
						elegirAB = eElegirAB.next();
						
						switch(elegirAB)
						{
							case "A":
							{
								salirMenuBuscar = true;
								break;
							}
							
							case "B":
							{
								salirMenuBuscar = true;
								break;
							}
						
							default:
							{
								System.out.println("RESPUESTA INVALIDA");
							}
						}
					}
					while(salirMenuBuscar == false);
						
					switch (elegirAB)
					{
						case "A":
						{
							System.out.println("INGRESE EL NOMBRE DEL ESTUDiANTE: ");
							System.out.println("EJEMPLO: Raul Valdivia");
							
							nombreEstudianteBuscado = eNombreEstudianteBuscado.next();
							
							resultado = estudiantes2023.buscarNombre(nombreEstudianteBuscado);
							
							break;
						}
						
						case "B":
						{
							System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE: ");
							System.out.println("EJEMPLO: 100");
							
							codigoEstudianteBuscado = eCodigoEstudianteBuscado.nextInt();
							
							resultado = estudiantes2023.buscarCodigo(codigoEstudianteBuscado);
							
							break;
						}
					}
					System.out.println(resultado);
					
					System.out.println("");
					System.out.println("DESEA INGRESAR OTRA OPCION?");
					System.out.println("");
					System.out.println("");
					
					break;
				}
				
				case 3:
				{
					boolean salirOpcion3 = false;
					
					int codigoEstudianteEliminar;
					
					String respuestaYN2 = new String();
					
					System.out.println("****** ELIMINACION DEL ESTUDIANTE ******");
					estudiantes2023.listarEstudiantes();
					
					do
					{
						System.out.println("INGRESE EL CODIGO DEL ALUMNO A ELIMINAR:");
						codigoEstudianteEliminar = eCodigoEstudianteEliminar.nextInt();
						
						System.out.println("ES ESTE EL CODIGO CORRECTO? Y/N");
						
						respuestaYN2 = eRespuestaYN2.next();
						
						if (respuestaYN2.equals("Y"))
						{
							for(int contador = 0; contador < estudiantes2023.tamano(); contador++)
							{
					    		if(codigoEstudianteEliminar == estudiantes2023.obtenerEstudiante(contador).getCodigo())
					    		{
					    			estudiantes2023.eliminar(estudiantes2023.obtenerEstudiante(contador));
					    		}
							}
							
							System.out.println("ESTUDIANTE ELIMINADO");
							salirOpcion3 = true;
						}
						
						else if(respuestaYN2.equals("N"))
						{
							System.out.println("INGRESE EL CODIGO CORRECTO");
						}
						
						else
						{
							System.out.println("RESPUESTA INVALIDA");
						}
					}
					while(salirOpcion3 == false);
					
					System.out.println("");
					System.out.println("DESEA INGRESAR OTRA OPCION?");
					System.out.println("");
					System.out.println("");
					
					break;
				}
				
				case 4:
				{
					boolean salirIngresarCodigoModificar = false;
					boolean salirConfirmaModificacion = false;
					int codigoEstudianteModificar;
					int cicloModificado;
					
					double pensionModificada;
					
					String respuestaYN3 = new String();
					String respuestaYN4 = new String();
					String nombreModificado = new String();
					String apellidoModificado = new String();
					String nombreCompletoModificado = new String();
					
					System.out.println("****** MODIFICACION DEL ESTUDIANTE ******");
					estudiantes2023.listarEstudiantes();
					
					do
					{
						System.out.println("INGRESE EL CODIGO DEL ALUMNO A MODIFICAR:");
						codigoEstudianteModificar = eCodigoEstudianteModificar.nextInt();
						
						System.out.println("ES ESTE EL CODIGO CORRECTO? Y/N");
						
						respuestaYN3 = eRespuestaYN3.next();
						
						if (respuestaYN3.equals("Y"))
						{
							salirIngresarCodigoModificar = true;
						}
						
						else if(respuestaYN3.equals("N"))
						{
							System.out.println("INGRESE EL CODIGO CORRECTO");
						}
						
						else
						{
							System.out.println("RESPUESTA INVALIDA");
						}
					}
					while(salirIngresarCodigoModificar == false);
						
					for(int contador = 0; contador < estudiantes2023.tamano(); contador++)
					{
			    		if(codigoEstudianteModificar == estudiantes2023.obtenerEstudiante(contador).getCodigo())
			    		{
			    			do
							{
								System.out.println("INGRESE LOS NUEVOS NOMBRES: ");
								nombreModificado = eNombreModificado.next();
								
								System.out.println("INGRESE APELLIDOS: ");
								apellidoModificado = eApellidoModificado.next();
								
								System.out.println("INGRESE CICLO: ");
								cicloModificado = eCicloModificado.nextInt();
								
								System.out.println("INGRESE PENSION: ");
								pensionModificada = ePensionModificada.nextDouble();
								
								System.out.println("ESTOS DATOS SON CORRECTOS? Y/N");
								respuestaYN4 = eRespuestaYN4.next();
								
								if (respuestaYN4.equals("Y"))
								{
									nombreCompletoModificado = nombreModificado + " " + apellidoModificado;
									
									estudiantes2023.obtenerEstudiante(contador).setNombre(nombreCompletoModificado);
									estudiantes2023.obtenerEstudiante(contador).setCiclo(cicloModificado);
									estudiantes2023.obtenerEstudiante(contador).setPension(pensionModificada);
									salirConfirmaModificacion = true;
								}
								
								else if (respuestaYN4.equals("N"))
								{
									System.out.println("VUELVA A INGRESAR LOS DATOS");
								}
								
								else
								{
									System.out.println("RESPUESTA INVALIDA");
								}
							}
							while(salirConfirmaModificacion == false);
							
							System.out.println("Se modifico con exito!");
							System.out.println("DESEA INGRESAR OTRA OPCION?");
							System.out.println("");
							System.out.println("");
			    		}
					}
					
					break;
				}
				
				case 5:
				{
					break;
				}
				
				case 6:
				{
					System.out.println("****** ESTUDIANTES DEL 2023 ******");
					estudiantes2023.listarEstudiantes();
					
					System.out.println("DESEA INGRESAR OTRA OPCION?");
					System.out.println("");
					System.out.println("");
					
					break;
				}
				
				case 7:
				{
					break;
				}
				
				case 8:
				{
					break;
				}
				
				case 9:
				{
					break;
				}
				
				case 10:
				{
					System.out.println("CERRANDO PROGRAMA");
					salirMenuPrincipal = true;
					
					break;
				}
				
				default:
				{
					System.out.println("CARACTER INVALIDO.");
					break;
				}
			}
		}
		while(salirMenuPrincipal == false);
		
		entradaMenu.close();
		
		eNuevoNombre.close();
		eNuevoApellido.close();
		eNuevoCiclo.close();
		eNuevaPension.close();
		eRespuestaYN1.close();

		eElegirAB.close();
		eNombreEstudianteBuscado.close();
		eCodigoEstudianteBuscado.close();

		eCodigoEstudianteEliminar.close();
		eRespuestaYN2.close();
		
		eCodigoEstudianteModificar.close();
		eRespuestaYN3.close();
		eRespuestaYN4.close();
		eNombreModificado.close();
		eApellidoModificado.close();
		eCicloModificado.close();
		ePensionModificada.close();
	}
}
