# Ejercicio Panadería

Eres el desarrollador encargado de simular el funcionamiento de una panadería self-service, donde los clientes pueden tomar las barras de pan directamente del mostrador. Sin embargo, hay una serie de restricciones que deberás implementar en tu solución.

## La panadería funciona con las siguientes reglas:

### 1. Condiciones iniciales:
- Al abrir la panadería, ya hay 20 barras en el mostrador que el panadero dejó preparadas el día anterior.

### 2. El panadero:
- Es responsable de hornear pan y mantener abastecido el mostrador.
- Cada segundo, el panadero revisa si hay menos de 10 barras en el mostrador. Si esto ocurre, se pone a hornear un nuevo lote de 20 barras, lo cual toma 20 segundos.
- Cuando el usuario selecciona la opción de cerrar la panadería, el panadero:
  - Se lleva todas las barras restantes del mostrador a su casa (deja el mostrador con 0 barras).
  - Horneará un lote final de 20 barras para el día siguiente antes de finalizar su trabajo.

### 3. Los clientes:
- Llegan en bloques (varios clientes al mismo tiempo) y no tienen por qué recoger el pan en orden (cliente1, cliente2, cliente3….), no nos importa el orden.
- Cada cliente pide entre 1 y 10 barras de pan.
- Si en el mostrador no hay suficientes barras para atender a un cliente, este esperará hasta que el panadero haya horneado más.

### 4. Recaudación:
- El precio de la primera barra es 1€, y cada barra adicional cuesta 0,75€.
- Por ejemplo:
  - 1 barra = 1€.
  - 2 barras = 1,75€.
  - 3 barras = 2,50€, y así sucesivamente.

### 5. Sincronización:
- Tanto los clientes como el panadero interactúan de forma concurrente con el mostrador de la panadería, por lo que debes garantizar que los accesos estén sincronizados para evitar errores como condiciones de carrera.

### 6. Menú de Usuario:
- 1. Registrar grupo de clientes:
  - Pregunta cuántos clientes llegan y cuántas barras desea cada uno antes de lanzar los hilos concurrentemente.
- 2. Ver estado del mostrador:
  - Muestra:
    - La cantidad actual de barras disponibles en el mostrador.
    - El dinero recaudado hasta el momento.
    - El número total de barras horneadas (incluyendo las iniciales y las horneadas durante el día).
- 3. Cerrar la panadería:
  - Cuando se elija esta opción:
    - El panadero se lleva todas las barras restantes del mostrador (se dejan a 0).
    - Horneará un lote final de 20 barras.
    - Se muestra un resumen con:
      - El total de barras vendidas.
      - El dinero recaudado.

## Salida Esperada
El programa debe mostrar mensajes detallados de cada acción:
- Clientes esperando o llevándose barras.
- El panadero horneando y reponiendo el mostrador.
- Estado final de la panadería al cerrar.

Ejemplo de salida:
<p align="center">
  <img src="https://i.ibb.co/SvbX2dK/Captura.png" alt="salida de la imagen">
</p>