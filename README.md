Documentacion de la practica 1.

Descripcion:
Para esta practica debemos implementar las 3 partes aprendidas en clase:
- Paso de Mensajeria
- Memoria Compartida
- Memoria Distribuida

Usamos esto en el algoritmo de multiplicacion de matrices. Y Comparamos lso tiempos de corrida entre cada uno.

Para la mensajeria me guie de los ejemplos en clase. A cada corrida le mande el productor el cual tiene la habilidad de mandar un mensaje y este puede ser recibido en el consumidor.
El consumidor solo imprime un string con los detalles de cada corrida.

La corrida normal utiliza el algoritmo de multiplicacion de matrices de geek for geeks, pero separe la suma y multiiplicacion continua a una funcion.

La diferencia entre mi distribuida y compartida es que la compartida utiliza y lee la misma matriz, mientras que la distribuida toma una copia de las matrices para cada calculo.

Analisis de los tiempos:
Siento que mi codigo no es el mas eficiente en cuanto a la implementacion de los threads. Puede ser que hago muchas llamadas y por eso incrementa el tiempo de carrida, pero por lo menos podemos comparar la Compatida y Distribuida.

Prove matrices de 2x2, 3x3 y 4x4.

Y encontre que, al usar mi implementacion, la corrida con memoria distribuida es mas corta que la compartida. Pero la implementacion de la compartida fue mas sencilla.
Debajo se encuenta la imagen comparando cada corrida.

![image](https://github.com/migueljnoboa/ParalelaConcurrentePractica1/assets/132306836/ef94ed5e-d508-48bf-864c-774a58fe9c50)
