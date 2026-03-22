
# Sistema de Transporte - Programación Orientada a Objetos
Este proyecto consiste en un sistema de transporte desarrollado en Java, 
que permite calcular el costo, tiempo y huella ecológica de diferentes vehículos 
según la distancia y la carga ingresada por el usuario.
## Objetivos
- Aplicar herencia y polimorfismo
- Implementar clases abstractas
- Comparar diferentes tipos de vehículos
- Calcular costo, tiempo y huella ecológica
## Tecnologías
- Java
- Programación Orientada a Objetos (POO)
- github
## Estructura del proyecto
- Vehiculo (clase abstracta)
- Terrestres (clase abstracta)
- Aereos (clase abstracta)
- Automovil
- Moto
- Camion
- Dron
- Ejecutable
- Main
## Funcionamiento

1. El usuario ingresa:
   - Distancia
   - Carga

2. El sistema:
   - Valida qué vehículos pueden realizar el envío
   - Calcula costo, tiempo y huella ecológica
   - Ordena las opciones

3. Se muestran:
   - Las mejores opciones
   - Las peores opciones

4. El usuario selecciona un vehículo válido
## Fórmulas
1. Costo:
    - costo = distancia * factor + carga * factor

2. Tiempo:
    - tiempo = distancia / velocidad
    
3. Huella ecológica:
    - huella = distancia * factor + carga * factor

## Ejemplo

Entrada:
Distancia: 100 km
Carga: 500 kg

    Salida:
    1. Moto | Costo: $45.000| Tiempo: 1 hora y 6 minutos  | Huella: 6.000
    2. Automovil | Costo: $65.000 | Tiempo: 1 hora y 25 minutos | Huella: 10.000
    3. camion | Costo: $110.00| Tiempo: 1 horas y 40 minutos| Huella: 19.000
    4. Dron | no aparece ya que la carga es mayor a su limite

## Autor

- Juan David Merchán
- Alan David Rodriguez Cruz

## Conclusión
El proyecto permite aplicar los conceptos fundamentales de la programación orientada a objetos,
demostrando el uso de herencia, abstracción y polimorfismo en un caso práctico no realiza al 100%.
   