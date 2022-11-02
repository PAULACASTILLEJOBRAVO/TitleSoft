
<body>
<H1>Titlesoft</h1>
<br>
<br>
<H2>1. Planificación y gestión</H2>
<p>Para la realización de este proyecto, hemos elegido un modelo de vida incremental debido a sus ventajas. Como evitar proyectos demasiado largos y poder dar algo que tenga valor para el
usuario, se conseigue mayor involucración del cliente y además los resultados suelen ser más positivos. Con este modelo conseguimos que el desarrollo avance en incrementos sacando módulos, 
y obteniendo como resultado la integración de los componentes.
</p>
<p>
En este proyecto se trabaja de forma adaptativa, es decir, cuando se ve que las cosas están saliendo correctamente es porque todo ha salido como se esperaba al principio con la 
planificaión inicial. Sin embargo, eso no quiere decir que esa planificación inicial sea la guía. De esta forma no es posible saber con exactitud qué es lo que se va a poder entregar, pero
se puede ir diciendo según va avanzando el proyecto. Una iteración nos durará cuatro semanas, y el objetivo de esta iteración es conseguir un prototipo operativo. 
Se ha tomado la decisión de priorizar los casos de uso por facilidad de implementación, ya que así se pueden obtener logros a más corto plazo. Sin embargo, también deben ser casos de uso que
sirvan a otros como base para minimizar los errores. 
</p>
<p>
Nuestro equipo ha tomado de elegir Scrum para la elaboración del proyecto ya que está basado en los principios del agilismo, con la opción de adaptarse a diferentes organizaciones obteniendo
resultados rápidos. Tabién tiene la capacidad de adpatarse a los diferentes cambios que puedan surgir de las necesidades de los clientes. 
Con el product backlog se podrá tener una visión que es única durante todo el proyecto. Dentro del porduct backlog se han establecido como prioritarios los requisitos de Login,
Realizar/Editar Propuesta Curso y Visualizar Propuesta Curso. La persona encarga de ordenar el product backlog es el product owner, la persona encargada de este rol en nuestro equipo es
Virginia López Marcos. Como Scrum Master tenemos a Paula Castillejo Bravo. Esta persona se encargará de representar la gestión del proyecto y tomará la responsabilidad de asegurar y mantener todos
los valores de Scrum. Este rol también es importante para poder habilitar correctamente la comunicación que debe haber entre los roles. Además puede blindar al equipos de cualquier 
influencia externa.
</p>
<p>
Como somos un equipo pequeño, todos (incluso las personas mencionadas anteriormente) pertenecerán al equipo de desarrollo. Los desarrolladores deben trabajar a tiempo completo y deben ser
multifincionales, autogestionados y no distribuidos. 
</p>
<p>
Para empezar a desarrollar el software, primero se ha hecho una reunión de todo el equipo para escoger aquellos elementos que están en el product backlog para realizarlos. Se crea el sprint 
backlog cuya funcionalidad es identificar las tareas que se estiman entre 1 hora y 16 horas. Estas tareas se se han realizado de forma colaborativa. Otra de las reuniones características
de Scrum son las Daily Scrum. Son reuniones de diarias de unos 15 minutos de duración. Debido a diferentes imprevistos no se han podido realizar diariamete, esto ha variado un poco más. 
Con estas reuniones hemos conseguido familiarizanos con las diferentes partes del proyecto que ha ido realizando cada miembro. Con esto es más fácil entender donde pueden surgir problemas
aunque no se resuelvan en este tipo de reuniones. Gracias a esto, en la reunión de la revisión del sprint es más fácil ayudar a resolver los problemas. Con esta reunión se pretende mostrar 
lo que se ha desarrollado. Como el product owner también ha participado en el desarrollo, no está tan centrado en enseñarle lo que se ha hecho, en nuestro caso está centrado en resolver las
dificultades que ha tenido cada persona. De esta forma se crea una reunión híbrida entre la reunión de revisión del sprint y la reuinión de retrospectiva del sprint (que en la teoría es donde
se mira lo que va bien y lo que no va bien). Con esta reunión híbrida cada miembro del equipo podrá mostrar lo que ha hecho y se pondrán soluciones a las cosas que no funcionen bien.
</p>
<br>

<br>
<H2>2.Memoria del Proyecto</H1>
<H3>2.1.Gestores</H3>
	<H4><p>Los archivos .java de controladores que son los encargados de comunicar las calses DAO que pertenecen a persistencia con la clases de presentacion, para ello tenemos diferentes .java es decir, los diferentes gestores. Tenemos uno para cada entidad controlando la accion a la DAO de su entidad.
	</p></H4>
	<H4><p>Por ejemplo tenemos en Controlador un GestorEstudiates, este tendra metodos para los utilice la presentacion como hemos dicho con anterioridad y dichos metodos se conectara con la persistencia, es decir con las DAO, en este caso el GestorEstudiantes tiene el metodo SeleccionarEstudiante() y este accede al metodo get() de EstudianteDAO.
	</p></H4>
<H3>2.2Entidades</H3>
	<H4><p>Aqui se encuentran las entidades siendo cada una una tabla de la base de datos teniendo cada una como propiedades las columnas de dicha base de datos.Ademas tendra los get,set y constructores los cuales seran necesarios en las clases DAO en persistencia para llevar a cabo la creacion de los objetos de estas entidades y trabajar con ellas y por supuesto el poder guardarlo en la base de datos
	</p></H4>
	<H4><p>Por ejemplo, siguiendo el ejemplo anterior tanto el metodo SeleccionarEstudiante() como el metodo get() de EstudianteDAO te retorna un objeto tipo Estudiante por lo que sera necesario crear dicho estudiante a traves del contructor. Y es en el get de EstudiateDAO donde se construye y se accede a la base de datos
	</p></H4>
	
<H3>2.3.Persistencia</H3>
	<H4><p>Estas clases son las encargadas de acceder a la base de datos,es decir, crear las sentencias sql para guardar datos en ella, para recogerlos e incluso para borralos. Para ello tendra metodos que accedan al GestorBD,estas clases DAOs extienden de una clase abstracta. Dicho GestorBD es el encargado de establecer la conexion con la base de datos teniendo metodos de conexion y desconexion.
	</p></H4>
<H3>2.4.Presentacion</H3>
	<H4><p>En presentacion nos encontraremos las clases que crean la interfaz de usuario y son los que llaman a los metodos de los controladores como mencionamos en el primer apartado. Nos encontraremos un .java para cada tipo de usuario,es decir, uno para estudiantes, otro para vicerrector, etc. Ademas encontraremos algunos extras para aquellas acciones mas complejas o conjunto de ellas que realiza un usuario y que se pueden agrupar como la matriculacion.
	</p></H4>
<br>
  
<br>
<h2>3. Gestión de la Configuración:
</h2>
<h3>3.1. Introducción:
</h3>
<p>Este documento describe todas las acciones de Gestión de Configuración que realizaremos durante todo el ciclo de vida del proyecto. La planificación de la configuración describe las actividades que deben ser llevadas durante el proceso de desarrollo del proyecto.  Hay que identificar los cambios para así establecer el estado de cada uno desde su nacimiento hasta su agregación.
</p>
<br>
<h4>3.1.1. Proposito del plan:
</h4>
<p>Construir un sistema software que sea capaz de gestionar las diferentes enseñanzas, que son propias de la universidad de la UCLM. Se van a considerar que las enseñanzas propias serán todas aquellas organizadas por la misma universidad. Nuestro principal objetivo es gestionar todas las titulaciones de estas enseñanzas.
</p>
<br>
<h4>3.1.2. Alcance del plan:
</h4>
<p>El tiempo que vamos a emplear para hacer posible el proyecto va a ser desde el 21 septiembre hasta el día de la entrega del proyecto que es el 22 de diciembre. A lo que queremos llegar con el proyecto, es satisfacer las necesidades básicas cuando un profesor proponga cursos nuevos. Todo esto con el fin de que la universidad sea más amplia a la hora de escoger una titulación, realizar consultas de los determinados cursos o también que los estudiantes hagan la matricula.
</p>
<br>
<h4>3.1.3. Relación con la organización y con otros proyectos:
</h4>
<p>El sistema software que se va a implementar deberá recoger los usuarios que participarán en estas enseñanzas. Una vez finalizada cada enseñanza, el sistema le mandará los títulos generados a cada persona al sistema principal de la universidad.
</p>
<br>
<h4>3.1.4. Términos clave:
</h4>
<p>1.	Línea base: es un documento revisado y con el que se ha llegado a un acuerdo, para establecerlo como referencia de posteriores desarrollos. Solo debe cambiarse mediante el control de cambios. 
</p>
<p>2.	Control de cambios: Es el proceso encargado de la gestión de las solicitudes de los cambios que se quieren hacer.
</p>
<p>3.	Versiones: Es un proceso donde se le asigna un identificador (un nombre, un código, un número...) al software. De esta forma se puede indicar su nivel de desarrollo.
</p>
<br>
<h4>3.1.5. Referencias:
</h4>
<p>ANSI/IEEE Std 828-1990, IEEE Estándar for Sofware Configuration Management Plans.
</p>
<p>Mantenimiento y Evolución de Sistemas de Información, Ricardo Pérez del Castillo, Francisco Ruíz González, Ignacio Rodríguez, Macario Polo Piattini Velthuis, Mario G. 
</p>
<br>
<h3>3.2. Criterios para la identificación de los elementos de configuración a los cuales el CM será aplicado:
</h3>
<p>Con la gestión de la configuración, lo que se pretende es garantizar que el sistema funcione siempre como es de esperar. Aunque se vayan realizando cambios. Sabiendo esto, podemos llegar a la conclusión de que, algunos de los elementos a los que se va a aplicar la gestión de configuración son: la especificación de los requisitos, el código fuente (que es algo que se tiene modificar en mayor o menor medida, cuando se produce un cambio en la funcionalidad el programa), los modelos de procesos, modelo de datos, los ejecutables y las pruebas.
</p>
<br>
<p>3.3. Limitaciones y suposiciones que afectan al plan:
</p>
<p>Las limitaciones y suposiciones que afectan a nuestro plan son los siguientes: 
</p>
<p>1.	Coste: porque no podemos predecir si vamos a tener el suficiente dinero para poder llevar el proyecto a delante.
</p>
<p>2.	Recursos: también puede ser otro límite ya que puede ser que no tengamos las herramientas para poder trabajarlo bien.
</p>
<p>3.	Tiempo: es siempre un problema. Si no se organiza bien, no se llegará al día de la entrega.
</p>
<p>4.	Calidad: el software tiene que ser bueno ya que no podemos entregar un producto hecho con prisas y mal, sino que debemos tener presente que el cliente está pagando por ese software. 
</p>
<p>5.	Riesgo: vamos a tener que hacer un registro de los riesgos para evaluar la probabilidad y la gravedad de cada uno de los problemas y así poder reparar los más probables y graves que pude ser que pasen.
</p>
<p>6.	Alcance: este punto está relacionado con el anterior (Riesgo) ya que si no se tiene un control adecuado de los riesgos no vamos a poder llegar a obtener el alcance que queremos con el producto software.
</p>
<br>
<h3>3.4. Responsabilidades y autoridades del Plan:
</h3>
<p>Normalmente, la responsabilidad y la autoridad van de la mano. La primera se mueve hacia arriba, mientras que la segunda fluye hacia abajo. Según los catorce principios de Henri Fayol, “La autoridad es el derecho a dar órdenes y el poder de exigir obediencia” mientras que Theo Haimann afirma “La responsabilidad es la obligación de un subordinado para realizar la función solicitada por un superior”. Es difícil imaginar responsabilidad sin autoridad.
</p>
<br>
<h3>3.5. Organización del proyecto:
</h3>
<p>Los temas por tratar en este punto son varios y están fuertemente relacionados: 
</p>
<p>1.	Gestión de proyecto: participación en las determinaciones frente a grandes cambios del sistema.
</p>
<p>2.	Especialistas técnicos: son las personas que se van a encargar de decidir que herramientas se utilizan para llevar a cabo de manera adecuada las actividades.
</p>
<p>3.	Implementación:  relacionado con la fase de construcción del sistema, supervisión de cambios del código y también cambios en la línea base del proyecto.
</p>
<p>4.	Requerimientos: supervisión de cambios de requerimientos.
</p>
<p>5.	Gestión de calidad: tiene que ver con procesos de verificación en la línea base del proyecto.
</p>
<br>
<h3>3.6. Responsabilidades de CM:
</h3>
<p>El gestor de configuración debe ser el responsable de:
</p>
<p>1.	Gestionar todos los procesos de identificación, seguimiento, planificación, auditoría y control de cada uno de los elementos de configuración que hay en la base de datos (de la parte de configuración). 
</p>
<p>2.	Por otro lado, el gestor de la configuración también deberá ser capaz de desarrollar adecuadamente todo el plan de gestión de configuración.
</p>
<p>3.	Deberá ser responsable de fomentar el empleo de adecuado de la base de datos de la configuración.
</p>
<p>4.	Todos los cambios que no sean autorizados deben ser reportados y monitoreados por el gestor de configuración.
</p>
<p>5.	Es muy importante la integridad y la consistencia asegurada de la base de datos mediante una serie de procesos, encargados de la auditoría y la verificación. 
</p>
<p>6.	Otro factor importante es el poder liderar todas las actividades, pertenecientes a la evaluación del proceso. Por ejemplo, revisar los atributos, las relaciones, lo derechos de acceso...
</p>
<p>7.	Es posible que con el tiempo se vayan considerando algunos cambios estructurales en la base de datos. El gestor de la configuración deberá ser el encargado de aprobarla o no.
</p>
<br>
<h3>3.7. Políticas aplicables, directivas y procedimientos:
</h3>
<p>Los empleados deben cumplir las siguientes directrices:
</p>
<p>1.	Desmentir la corrupción en cualquier puesto de trabajo dentro de la organización, sobre todo los altos y medios cargos. 
</p>
<p>2.	Fomentar un espíritu laboral en todos los empleados para el buen funcionamiento y ambiente profesional.
</p>
<p>3.	Manejar precios accesibles al consumidor.
</p>
<p>4.	Una de las preferencias es la calidad del producto.
</p>
<p>5.	Los miembros poseerán una credencial de identificación.
</p>
<p>6.	El personal siempre deberá mantener un comportamiento ético, moral y respetuoso.
</p>
<p>7.	Se trabajará en base a las expectativas y demandas ya vistas en otros encargos de cada cliente.
</p>
<p>7.	Se trabajará en base a las expectativas y demandas ya vistas en otros encargos de cada cliente.
</p>
<br>
<br>
<h3>3.8. Actividades planificadas, agenda y recursos:
</h3>
<p>Las siguientes actividades han sido planificadas acorde a su prioridad:
</p>


<table border="solid 5px black" >
	<tr>
		<td>    </td>
		<td> Duración </td>
		<td> Duración redondeada </td>
		<td> Inicio </td>
		<td> Finalización </td>
	</tr>
	<tr>
		<td> Reuniones de Planificación </td>
		<td> 1 día </td>
		<td> 0,14 </td>
		<td> 30/9/2022 </td>
		<td> 30/9/2022 </td>
	</tr>
	<tr>
		<td> Reuniones de Revisión </td>
		<td> 7 días </td>
		<td> 1 </td>
		<td> 12/10/2022 </td>
		<td> 12/10/2022<spam id="yo">A</spam>S </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 25/10/2022 </td>
		<td> 25/10/2022 </td>
	</tr>
	<tr>
		<td>  </td>
    <td>  </td>
		<td>  </td>
		<td> 1/11/2022 </td>
		<td> 1/11/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 12/11/2022 </td>
		<td> 12/11/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 20/11/2022 </td>
		<td> 20/11/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 12/12/2022 </td>
		<td> 12/12/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 25/12/2022 </td>
		<td> 25/12/2022 </td>
	</tr>
	<tr>
		<td> Revisión de Restropectiva </td>
		<td> 2 días </td>
		<td> 0,28 </td>
		<td> 2/11/2022</td>
		<td> 2/11/2022 </td>	
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 21/12/2022 </td>
		<td> 21/12/2022 </td>
	</tr>
	<tr>
		<td> Daily Scrum </td>
		<td> 3 días </td>
		<td> 0,42 </td>
		<td> 9/10/2022 </td>
		<td> 9/10/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 23/10/2022 </td>
		<td> 23/10/2022 </td>
	</tr>
	<tr>
		<td>  </td>
		<td>  </td>
    <td>  </td>
		<td> 26/11/2022 </td>
		<td> 26/11/2022 </td>
	</tr>
	<tr>
		<td> Persistencia </td>
		<td> 1 día </td>
		<td> 0,14 </td>
		<td> 10/10/2022 </td>
		<td> 10/10/2022 </td>
	</tr>
	<tr>
		<td> Lógica/Negocio </td>
		<td> 12 días </td>
		<td> 0,71 </td>
		<td> 10/10/2022 </td>
		<td> 22/10/2022 </td>
	</tr>
	<tr>
		<td> Presentación </td>
		<td> 3 días </td>
		<td> 0,42 </td>
		<td> 20/10/2022 </td>
		<td> 22/10/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 1 </td>
		<td> 5 días </td>
		<td> 0,85 </td>
		<td> 24/10/2022 </td>
		<td> 30/10/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 2 </td>
		<td> 5 días </td>
		<td> 0,85 </td>
		<td> 24/10/2022 </td>
		<td> 30/10/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 3 </td>
		<td> 5 días </td>
		<td> 0,85 </td>
		<td> 27/10/2022 </td>
		<td> 31/10/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 4 </td>
		<td> 9 días </td>
		<td> 1,28 </td>
		<td> 3/11/2022 </td>
		<td> 11/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 5 </td>
		<td> 9 días </td>
		<td> 1,28 </td>
		<td> 3/11/2022 </td>
		<td> 11/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 6 </td>
		<td> 7 días </td>
		<td> 1 </td>
		<td> 13/11/2022 </td>
		<td> 19/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 7 </td>
		<td> 7 días </td>
		<td> 1 </td>
		<td> 13/11/2022 </td>
		<td> 19/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 8 </td>
		<td> 7 días </td>
		<td> 1 </td>
		<td> 13/11/2022 </td>
		<td> 19/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 9 </td>
		<td> 7 días </td>
		<td> 1 </td>
		<td> 13/11/2022 </td>
		<td> 19/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 10 </td>
		<td> 6 días </td>
		<td> 0,85 </td>
		<td> 21/11/2022 </td>
		<td> 26/11/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 11 </td>
		<td> 8 días </td>
		<td> 1,14 </td>
		<td> 28/11/2022 </td>
		<td> 9/12/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 12 </td>
		<td> 8 días </td>
		<td> 1,14 </td>
		<td> 28/11/2022 </td>
		<td> 9/12/2022 </td>
	</tr>
	<tr>
		<td> Caso de Uso 13 </td>
		<td> 8 días </td>
		<td> 1,14 </td>
		<td> 28/11/2022 </td>
		<td> 9/12/2022 </td>
	</tr>
	<tr>
		<td> Testing </td>
		<td> 10 días </td>
		<td> 1,4 </td>
		<td> 11/12/2022 </td>
		<td> 20/12/2022 </td>
	</tr>
</table>
	
<h4> 3.8.1. Agendas del CM: 
</h4>
	
<div class="tabla"><table border="solid 5px black">
	<tr>
		<td> Semana </td>
		<td> Mes </td>
		<td> L </td>
		<td> M </td>
		<td> X </td>
		<td> J </td>
		<td> V </td>
		<td> S </td>
		<td> D </td>
	</tr>
	<tr>
		<td> 1 </td>
		<td> Octubre </td>
		<td> 26 </td>
		<td> 27 </td>
		<td> 28 </td>
		<td> 29 </td>
		<td> 30 </td>
		<td> 1 </td>
		<td> 2 </td>
	</tr>
	<tr>
		<td> 2 </td>
		<td>   </td>
		<td> 3 </td>
		<td> 4 </td>
		<td> 5 </td>
		<td> 6 </td>
		<td> 7 </td>
		<td> 8 </td>
		<td> 9 </td>
	</tr>
	<tr>
		<td> 3 </td>
		<td>  </td>
		<td> 10 </td>
		<td> 11 </td>
		<td> 12 </td>
		<td> 13 </td>
		<td> 14 </td>
		<td> 15 </td>
		<td> 16 </td>
	</tr>
	<tr>
		<td> 4 </td>
		<td>  </td>
		<td> 17 </td>
		<td> 18 </td>
		<td> 19 </td>
		<td> 20 </td>
		<td> 21 </td>
		<td> 22 </td>
		<td> 23 </td>
	</tr>
	<tr>
		<td> 5 </td>
		<td>  </td>
		<td> 24 </td>
		<td> 25 </td>
		<td> 26 </td>
		<td> 27 </td>
		<td> 28 </td>
		<td> 29 </td>
		<td> 30 </td>
	</tr>
	<tr>
		<td> 6 </td>
		<td> Noviembre </td>
		<td> 31 </td>
		<td> 1 </td>
		<td> 2 </td>
		<td> 3 </td>
		<td> 4 </td>
		<td> 5 </td>
		<td> 6 </td>
	</tr>
	<tr>
		<td> 7 </td>
		<td>  </td>
		<td> 7 </td>
		<td> 8 </td>
		<td> 9 </td>
		<td> 10 </td>
		<td> 11 </td>
		<td> 12 </td>
		<td> 13 </td>
	</tr>
	<tr>
		<td> 8 </td>
		<td>  </td>
		<td> 14 </td>
		<td> 15 </td>
		<td> 16 </td>
		<td> 17 </td>
		<td> 18 </td>
		<td> 19 </td>
		<td> 20 </td>
	</tr>
	<tr>
		<td> 9 </td>
		<td>  </td>
		<td> 21 </td>
		<td> 22 </td>
		<td> 23 </td>
		<td> 24 </td>
		<td> 25 </td>
		<td> 26 </td>
		<td> 27 </td>			
	</tr>
	<tr>
		<td> 10 </td>
		<td> Diciembre </td>
		<td> 28 </td>
		<td> 29 </td>
		<td> 30 </td>
		<td> 1 </td>
		<td> 2 </td>
		<td> 3 </td>
		<td> 4 </td>
	</tr>
	<tr>
		<td> 11 </td>
		<td>  </td>
		<td> 5 </td>
		<td> 6 </td>
		<td> 7 </td>
		<td> 8 </td>
		<td> 9 </td>
		<td> 10 </td>
		<td> 11 </<td>
	</tr>
	<tr>	
		<td> 12 </td>
		<td>  </td>
		<td> 12 </td>
		<td> 13 </td>
		<td> 14 </td>
		<td> 15 </td>
		<td> 16 </td>
		<td> 17 </td>
		<td> 18 </td>
	</tr>
	<tr>
		<td> 13 </td>
		<td>  </td>
		<td> 19 </td>
		<td> 20 </td>
		<td> 21 </td>
		<td> 22 </td>
		<td> 23 </td>
		<td> 24 </td>
		<td> 25 </td>
	</tr>
</table></div>
<br>
<h4>3.8.2. Recursos del CM:
</h4>
<p>Como recurso principal se usará GitHub, ya que este permite crear diferentes versiones del producto software, además de usar la ramificación cuando sea necesario.
</p>
<br>
<h3> 3.9. Mantenimiento del Plan de CM: 
</h3>
<p> Tenemos varios mantenimientos en los que nos podemos ayudar para poder llegar a que el programa no quede obsoleto:
</p>
<p>1.	Mantenimiento preventivo: es mantenimiento y su trabajo es mantener cierto nivel de servicio en la unidad, programar intervenciones y analizar sus vulnerabilidades en el momento más adecuado. Suelen ser sistemáticos, es decir, interviene a través del equipo no se dan síntomas problemáticos.
</p>
<p>2.	Mantenimiento correctivo: este es un conjunto de medidas correctivas. Errores que ocurren en diferentes dispositivos.
</p>
	
</body>
