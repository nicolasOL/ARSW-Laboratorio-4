# ARSW-Laboratorio-4
## German Andres Ospina
## Nicolas Ortega Limas
## Punto 3
El componente CinemaRESTAPI funcionará en un entorno concurrente. Es decir, atenderá                                                
múltiples peticiones simultáneamente (con el stack de aplicaciones usado, dichas                                                
peticiones se atenderán por defecto a través múltiples de hilos). Dado lo anterior, debe                                                          
hacer una revisión de su API (una vez funcione), e identificar:                                                
* Qué condiciones de carrera se podrían presentar?                                                     
Se podría presentar el caso en el que dos peticiones quieran hacer una actualización de las funciones de un cinema en especial a través del método PUT. 
* Cuales son las respectivas regiones críticas?                                                  
La región critica identificada se encuentra en el metodo la componente Controller updateCinemaByName.

Ajuste el código para suprimir las condiciones de carrera. Tengan en cuenta que                                                 
simplemente sincronizar el acceso a las operaciones de persistencia/consulta                                         
DEGRADARÁ SIGNIFICATIVAMENTE el desempeño de API, por lo cual se deben buscar                                        
estrategias alternativas.                         

Escriba su análisis y la solución aplicada en el archivo ANALISIS_CONCURRENCIA.txt
