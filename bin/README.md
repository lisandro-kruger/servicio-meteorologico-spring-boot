# Servicio Meteorologico Nacional
Descripción del problema:
El servicio meteorológico nacional desea implementar un sistema informático que provea
información del clima, la cual estará disponible para ser consultada en la web
Se planea proveer información de las condiciones climáticas para el día presente y los
próximos 10 días para cada ciudad del país.
Se proveerán los siguientes datos:
- Temperatura actual
- Descripción del estado actual del clima (despejado, nublado, lluvioso, nevando)
- Porcentaje de humedad
- Pronostico (para los próximos días):
                                      o Fecha pronosticada
                                      o Porcentaje de probabilidad de lluvias
                                      o Cantidad de lluvia prevista en mm
                                      o Descripción del pronóstico

También se requiere implementar un servicio de alertas meteorológicas automáticas ante
eventos climáticos extremos en el día en curso o el siguiente, para lo cual los usuarios podrán
suscribirse al servicio mediante su correo electrónico y registrando sus datos personales.
Se deberá plantear una solución web tanto para carga de información por parte del SMN como
para ser consultada por el público en general.
Note que la información a cargar no será solamente datos climáticos, sino también alta y
modificación de ciudades y provincias, carga de empleados del SMN, con sus respectivos
usuarios para acceder al sistema.

HISTORIA 1: Como Administrador del SMN
Quiero poder registrar/editar datos del clima
actual para una ciudad determinada
Para que los usuarios puedan tener información
del clima actual y pronóstico extendido
Estimación: 8 Prioridad: Muy Alta Riesgo: Bajo

Criterios de Aceptación:
✓ El usuario debe poder elegir la ciudad deseada
(de una lista de ciudades) y cargar los siguientes
datos del clima actual para esa ciudad :
o Temperatura (entero >=0)
o Estado del clima *
o porcentaje de humedad (entero >=0)
✓ Los datos se deben poder actualizar tantas veces
como sea necesario para la ciudad
* El estado del clima será seleccionado de una
lista de posibles valores (configurable desde la
base de datos):
o Despejado
o Nublado
o Lluvioso
o Nevando
✓ Todos los datos son requeridos

HISTORIA 2: Como Administrador del SMN
Quiero poder registrar/editar datos del pronóstico
extendido del clima para una ciudad determinada
Para que los usuarios puedan tener información
del pronóstico extendido
Estimación: 13 Prioridad: Muy Alta Riesgo: Bajo

Criterios de Aceptación:
✓ El sistema debe presentar al usuario una grilla
con la lista de pronósticos cargados en el sistema
(no mostrará pronósticos de días pasados ni
actual, solo futuros)
✓ Se deberá poder editar los datos de un
pronóstico previamente cargado o insertar uno
nuevo (no eliminar)
✓ Los datos del pronóstico a registrar/editar serán:
o Ciudad (elegida de una lista de
ciudades)
o Fecha pronosticada (fecha futura)
o Porcentaje de probabilidad de lluvias
(nro entero >= 0)
o Cantidad de lluvia prevista en mm (nro
entero >= 0)
o Descripción del pronóstico (texto de
hasta 500 caracteres)

✓ No podrá haber dos pronósticos para el mismo
día, para una misma ciudad
✓ Todos los datos son requeridos

HISTORIA 3: Como Administrador del SMN
Quiero poder registrar datos de un evento
meteorológico extremo para una ciudad
determinada
Para que se dispare la alerta correspondiente a
aquellos usuarios suscriptos al sistema de alertas
Estimación: 8 Prioridad: Alta Riesgo: Bajo

Criterios de Aceptación:
✓ El sistema deberá permitir el ingreso de un
evento extremo para una ciudad determinada
para el día actual o el siguiente
✓ El sistema solicitará:
o ciudad (elegida de una lista de ciudades)
o descripción del evento (texto largo de
hasta 500 caracteres)

✓ El sistema no solo registrará estos datos en la
base de datos sino que también enviará la alerta
vía e-mail a quienes se hayan suscripto al
servicio de alertas para la ciudad
✓ Todos los datos son requeridos
✓ El registro no es editable, solo se permite
registrar.