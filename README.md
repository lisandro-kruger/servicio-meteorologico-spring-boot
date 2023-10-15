## Como Administrador del SMN
### Quiero poder registrar/editar datos del clima actual para una ciudad determinada
#### Para que los usuarios puedan tener información del clima actual y pronóstico extendido
Estimación: 8  
Prioridad: Muy Alta  
Riesgo: Bajo

#### Criterios de Aceptación:
El usuario debe poder elegir la ciudad deseada y cargar los siguientes datos del clima actual para esa ciudad :
- Temperatura (entero >=0)
- Estado del clima * 
- porcentaje de humedad (entero >=0)

Los datos se deben poder actualizar tantas veces como sea necesario para la ciudad 

* El estado del clima será seleccionado de una lista de posibles valores (configurable desde la base de datos): 
- Despejado
- Nublado
- Lluvioso
- Nevando

Todos los datos son requeridos

## Como Administrador del SMN 
### Quiero poder registrar/editar datos del pronóstico extendido del clima para una ciudad determinada
#### Para que los usuarios puedan tener información del pronóstico extendido
Estimación: 13  
Prioridad: Muy Alta  
Riesgo: Bajo

#### Criterios de Aceptación:
El sistema debe presentar al usuario una grilla con la lista de pronósticos cargados en el sistema (no mostrará pronósticos de días pasados ni actual, solo futuros)

Se deberá poder editar los datos de un pronóstico previamente cargado o insertar uno nuevo (no eliminar)

Los datos del pronóstico a registrar/editar serán:
- Ciudad
- Fecha pronosticada (fecha futura)
- Porcentaje de probabilidad de lluvias (nro entero >= 0)
- Cantidad de lluvia prevista en mm  (nro entero >= 0)
- Descripción del pronóstico (texto de hasta 500 caracteres)

No podrá haber dos pronósticos para el mismo día, para una misma ciudad

Todos los datos son requeridos

## Como Administrador del SMN 
### Quiero poder registrar datos de un evento meteorológico extremo para una ciudad determinada
#### Para que se dispare la alerta correspondiente a aquellos usuarios suscriptos al sistema de alertas
Estimación: 8  
Prioridad: Alta  
Riesgo: Bajo

#### Criterios de Aceptación:
El sistema deberá permitir el ingreso de un evento extremo para una ciudad determinada para el día actual o el siguiente

El sistema solicitará: 

Los datos del evento a registrar/editar serán:
- ciudad
- descripción del evento (texto largo de hasta 500 caracteres) 

El sistema no solo registrará estos datos en la base de datos sino que también enviará la alerta vía e-mail a quienes se hayan suscripto al servicio de alertas para la ciudad 

Todos los datos son requeridos

El registro no es editable, solo se permite registrar

## Como Usuario
### Quiero poder consultar el estado actual del clima y pronóstico para los próximos 10 días para una ciudad determinada
#### Para poder estar al tanto de las condiciones climáticas del lugar
Estimación: 8  
Prioridad: Muy Alta  
Riesgo: Bajo

#### Criterios de Aceptación:
El usuario elige una ciudad sobre la que se desea consultar y el sistema muestra tanto el estado del clima actual para esa ciudad como la lista de pronósticos para los próximos 10 días (si lo hubiera)

No podrá modificar ninguno de los datos climáticos de la ciudad
