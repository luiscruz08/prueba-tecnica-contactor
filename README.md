
# Prueba tecnica contactos


## Descripción
Es una aplicación para la gestión de contactos hecha en Jetpack Compose, al momento de la entrega cuenta unicamente las siguientes funcionalidades
1) Obtener contactos: Obtiene todos los contactos registrados
2) Ordenar contactos: Los ordena de forma ascendente y descendente tomando como criterio el nombre
3) Buscar contactos: Busca el texto ingresado en los campos de cada contacto (Nombre, Apellido, Correo, Teléfono)
4) Crear contacto: Permite crear un contacto y almacenarlo en una base de datos local.

## Principales librerias
1) Dagger Hilt: Se utiliza para la inyección de dependencias
2) Room: Es la encargada de gestionar la base de datos
3) Navigation-Compose: Se utiliza para la navegación entre los composables
3) Google Truth: Se utiliza para hacer validaciones en los test

## Arquitectura 

Se basa en clean architecture, a continuación se describen sus capas, archivos de cada capa y su utlidad.
1) Presentación: Dicha capa se encarga de la UI y la navegación, cuenta con los siguientes archivos: 
a) Composable: Es el encargado de definir la UI y recibir las acciones del usuario como clicks, edición de datos o gestos.

b) ViewModel: Se encarga de gestionar la comunicación entre la UI y la capa de dominio, también almacena el estado de la vista y maneja los eventos.

c) State: Es la clase que contiene todo el estado de la vista, la cual es instanciada en el ViewModel para su uso.

d) Event: Es la clase que contiene los eventos que modifican el estado de la vista.

2) Dominio: Esta capa se encarga de definir las operaciones que realiza la aplicación, los modelos de datos utilizados en la capa Dominio y Presentación, los archivos utilizados son los siguientes: 
a) Model: Son dataclass que modelan los datos utilizados en esta capa y en la capa de Presentación.

b) Repository: Es una interfaz que define las operaciones que podemos realizar en la aplicación, dicha interfaz se implementará en la capa de Datos.

c) UseCase: Dicha clase define las reglas de negocio en la operación a realizar, puede sonar muy similar al Repository sin embargo, esta clase hace uso de la implementación del Repository y agrega lógica para su correcto funcionamiento como puede ser filtrar, ordenar, realizar alguna tarea antes o despues de la tarea principal.

3) Data: Se encarga de gestionar la información que se utiliza en la aplicación puede ser de manera local en una base de datos local como en este caso Room o a través de un Backend usando alguna libreria como Retrofit, los archivos principales en este proyecto son: 
a) Entity: Define las columnas que tendrá la tabla de nuestra base de datos.

b) Dao: Es una interfaz que define las operaciones que podemos realizar en nuestra base de datos.

c) Repository: Es la implementación del Repository definido en la capa Dominio, su principal función es definir la lógica en la gestión de datos, puede seleccionar de donde obtener la información, donde almacenarla, incluso podría contener la lógica de actualización de datos locales o remotos.

3) Core: Es una capa axuliar que contiene componentes reutilizables en la aplicación principalmente son dos componentes: 
a) DI: Contiene los módulos de Hilt que inyectaremos en nuestra aplicación, dichos módulos son utilizados para hacer implementaciones de interfaces como Room, Retrofit o la forma en la que en este proyecto se manejaron los repositorios.

b) Navigation: Contiene dos archivos que nos permiten gestionar la navegación con la libreria de compose navigation.

# Areas de mejora

1) Culminar las funcionalidades, no esta completo y sin duda es lo principal a mejorar
2) UI/ UX, de las funcionalidades terminadas no se ha trabajado demasiado en la parte de la UI
3) Uso de SQLDELIGTH, era un requisito implementar una db multiplataforma y aunque Room puede usarse hasta donde tengo entendido no hay una versión estable para KMP.
3) Internacionalización a traves de la extración de Strings en los composables al archivo strings.xml
3) Modularización: Adaptar las capas y en su defecto los módulos para este conjunto de funcionalidades con el fin de poderlo acoplar a proyectos nuevos de una forma simple
4) Pruebas de UI y End to End








    
