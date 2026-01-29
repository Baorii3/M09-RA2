## Preguntes teòriques
Has de contestar en el 06-Espera_wait/Readme.md en format markdown.

### Per què s’atura l’execució al cap d’un temps?
Perque tots el els que tenen reserva es queden en el wait()

### Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos
Si fos 70% reservar tardaria molt poc a acabar el programa 

>Asistent-1 ha fet una reserva. Places disponibles 4<br>
>Asistent-10 no ha pogut cancelar una reserva inexistent. Places disponibles 4<br>
>Asistent-9 no ha pogut cancelar una reserva inexistent. Places disponibles 4<br>
>Asistent-6 ha fet una reserva. Places disponibles 3<br>
>Asistent-8 ha fet una reserva. Places disponibles 2<br>
>Asistent-2 ha fet una reserva. Places disponibles 1<br>
>Asistent-7 ha fet una reserva. Places disponibles 0<br>
>Asistent-7 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-4 ha fet una reserva. Places disponibles 0<br>
>Asistent-2 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-9 ha fet una reserva. Places disponibles 0<br>
>Asistent-2 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-9 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-1 ha fet una reserva. Places disponibles 0<br>
>Asistent-9 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>PS D:\Usuaris\Ian\Escritorio\DAM2\Programacio de serveis\M09-RA2><br>

Si fos al reves tardaria molt mes
>...<br>
>Asistent-9 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-5 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-3 ha fet una reserva. Places disponibles 0<br>
>Asistent-2 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-5 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-7 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-4 ha fet una reserva. Places disponibles 0<br>
>Asistent-2 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-3 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-10 ha fet una reserva. Places disponibles 0<br>
>Asistent-5 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-10 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-6 ha fet una reserva. Places disponibles 0<br>
>Asistent-7 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-2 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-3 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-5 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-9 ha fet una reserva. Places disponibles 0<br>
>Asistent-10 ha cancel·lat una reserva. Places disponibles 1<br>
>Asistent-7 ha fet una reserva. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
>Asistent-6 no ha pogut cancelar una reserva inexistent. Places disponibles 0<br>
PS D:\Usuaris\Ian\Escritorio\DAM2\Programacio de serveis\M09-RA2> <br>

### Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
Porque si no tinguesim la llista no sabriem qui ha reservat i qui no.