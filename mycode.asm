; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h   

include 'emu8086.inc' 

    DEFINE_SCAN_NUM    ; preluare caractere de la tastatura
    DEFINE_PRINT_NUM     ;afisare mesaj
    DEFINE_PRINT_NUM_UNS

jmp start    ;salt conditionat catre prima parte a programului
    
    msg0 db "Vom calcula (a+b)^2 $" 
    msg1 db 0Dh,0Ah, 0Dh,0Ah, 'Adaugati: a= $'
    msg2 db 0Dh,0Ah, 0Dh,0Ah, 'Adaugati: b=  $'
    msg3 db 0Dh,0Ah, 0Dh,0Ah, ' (a+b)^2 =  $'
    
    ;aici se introduc cele doua numere
    primul dw ?
    doilea dw ?
                  
    ;inceput program  
    
    start:
    mov dx, offset msg0
    mov ah, 9
    int 21h
    
    
    lea dx, msg1   ; adresa efectiva a mesajului 
    mov ah, 09h    ; functia 'print char'
    int 21h  
    
    
    ;se citeste prima valoare de la tastatura
    call scan_num  
    
    
    ;salveaza aici valoarea primului numar - in registrul cx
    mov primul, cx 
    
    
    ;inceput de linie noua
    putc 0Dh
    putc 0Ah
    
    
    lea dx, msg2  ; adresa efectiva a mesajului
    int 21h  
    
    
    ;se citeste a doua valoare de la tastatura
    call scan_num
    
    
    ;salveaza aici valoarea celui de-al doilea numar - in registrul cx
    mov doilea, cx 
    
    
    lea dx, msg3     ;adresa efectiva a mesajului
    mov ah, 09h      ;apelare rutina de tratare intreruperi 0x21
    int 21h     
             
    
    ;aici se apeleaza calculul matematic
    jmp calcul
    
     
    calcul: mov ax, primul
           mov bx,doilea  
           add ax,bx       
           mul  ax
           call print_num 
           
    putc 13 ; linie noua
    putc 10

    print 'Trecem in mod grafic.'
   
    putc 13 ; linie noua
    putc 10
    print 'Apasa ENTER daca vrei sa continui. '


    lea si, msg
    call scan_num
    cmp ax,0
    jmp code
    
    msg DB ' ', 0
    
    ;linie noua
    putc 13
    putc 10
    
    print " "
    
    mov ax, cx
    call print_num
    
    hlt
    
    jmp code  ;salt conditionat catre a doua parte aprogramului: grafica 3D
           
       
       
    code: 
     mov ah, 0
     mov al, 13h ; trecere in mod grafic 320x200
     
     int 10h 
         
     ;introducerea unui sunet
     ;BEEP
     mov al,7
     mov ah,0eh
     int 10h
                
     ;pentru a desena o linie se seteaza coloana si linia de unde incepe desenul
     ;de asemenea se seteaza culoarea dorita
     ;apoi starea u cicleaza pana cand ajunge la valoarea dorita specificata prin cmp
     ;astfel, prin incrementarea/decrementarea liniei/coloanei se deseneaza fiecare linie in parte           
                
                
     ;afisare latura superioara
     mov cx, 130 ; coloana
     mov dx, 75 ;  linie
     mov al, 15 ; culoare  
     
    u1: mov ah, 0ch ; afisare pixel 
     mov al,07h
     int 10h
     inc cx ;incrementare cx
     cmp cx, 216 ;u1 cicleaza pana cand ajunge la valoarea 216, apoi trece mai departe in program
     jnz u1    
     
     ; afisare latura inferioare
     mov cx, 130
     mov dx, 170
     mov al, 30  
     
    u2: mov ah, 0ch
     mov al,07h
     int 10h
     inc cx
     cmp cx, 216
     jnz u2  
     
     ; latura din stanga
     mov cx, 130
     mov dx, 55
     mov al, 25 
     
    u3: mov ah, 0ch 
     mov al,07h
     int 10h
     inc dx 
     cmp dx, 170
     jnz u3   
     
     
     ; latura din dreapta
     mov cx, 216
     mov dx, 55
     mov al, 30   
     
     
     u4: mov ah, 0ch
     mov al,07h
     int 10h
     inc dx  
     cmp dx, 170
     jnz u4 
     
     mov cx,130
     mov dx,75
     mov al,20
     
     u5: mov ah, 0ch 
     mov al, 07h
     int 10h
     inc cx
     dec dx ;decrementez dx
     cmp cx, 150 
     cmp dx, 32
     jnz u5
     
     mov cx,216
     mov dx,75
     mov al,20 
     
     u6: mov ah, 0ch 
     mov al, 07h
     int 10h
     inc cx
     dec dx                                                        
     cmp cx, 150 
     cmp dx, 32
     jnz u6 
     
     mov cx,173
     mov dx,32
     mov al,20
    
     
     u7: mov ah, 0ch 
     mov al, 07h
     int 10h
     inc cx
     cmp cx,260 
     jnz u7
     
     mov cx, 260
     mov dx, 12
     mov al, 25 
     
    u8: mov ah, 0ch 
     mov al,07h
     int 10h
     inc dx   
     cmp dx, 127
     jnz u8
      
     mov cx,260
     mov dx,127
     mov al,20
     
     u9: mov ah, 0ch 
     mov al, 07h
     int 10h
     inc dx
     dec cx
     cmp cx, 70 
     cmp dx, 170
     jnz u9    
     
     mov cx,173
     mov dx,127
     mov al,20
     
     u10: mov ah, 0ch 
     mov al, 07h
     int 10h
     inc dx
     dec cx
     cmp cx,50
     cmp dx, 170
     jnz u10  
     
     mov cx, 173
     mov dx, 127
     mov al, 30  
     
    u11: mov ah, 0ch
     mov al,07h
     int 10h
     inc cx
     cmp cx, 260
     jnz u11
     
     
     mov cx, 173
     mov dx, 12
     mov al, 25 
     
    u12: mov ah, 0ch 
     mov al,07h
     int 10h
     inc dx   
     cmp dx, 127
     jnz u12  
     
     mov cx, 130
     mov dx, 55
     mov al, 25 
     
    u13: mov ah, 0ch 
     mov al,07h
     int 10h 
     inc cx              
     cmp cx, 216
     jnz u13  
     
     mov cx, 173
     mov dx, 12
     mov al, 25 
     
    u14: mov ah, 0ch 
     mov al,07h
     int 10h 
     inc cx              
     cmp cx, 260
     jnz u14  
    
     ;linii tranversle 
     
     ; latura din stanga1
     mov cx, 140
     mov dx, 65
     mov al, 40
     
    u15: mov ah, 0ch 
     mov al,40
     int 10h
     inc dx   
     cmp dx, 160
     jnz u15   
     
     ; latura din stanga2
     mov cx, 157
     mov dx, 50
     mov al, 40
     
    u16: mov ah, 0ch 
     mov al,40
     int 10h
     inc dx   
     cmp dx, 143
     jnz u16   
     
     ; latura din dreapta1
     mov cx, 230
     mov dx, 63
     mov al, 40 
     
    u17: mov ah, 0ch 
     mov al,40
     int 10h
     inc dx   
     cmp dx, 159
     jnz u17   
     
     ; latura din dreapta2
     mov cx, 250
     mov dx, 44
     mov al, 40
     
    u18: mov ah, 0ch 
     mov al,40
     int 10h
     inc dx  
     cmp dx, 139
     jnz u18
     
     
     mov dx,80
     mov bx,101
     
     ;Incepe desenarea copacului
                     
     desenarecopac:    
     mov cx,126
     sub cx,bx
     
     tree: mov ah,0ch
     mov al,02h
     int 10h
     inc cx
     cmp cx,bx
     jnz tree  
     
     cmp bx,65
     jle break
     
     sub dx,3
     sub bx,2
     
     jmp  desenarecopac
    
     break:
                       
     ;Incepere desenare trunchi copac  
               
     mov cx,55   
     mov dx,120 
     
     treeleft: mov ah,0ch
     mov al,06h
     int 10h
     dec dx
     cmp dx,80
     jnz treeleft
     
     mov cx,71
     mov dx,120 
     
     treeright: mov ah,0ch 
     mov al,06h
     int 10h
     dec dx
     cmp dx,80
     jnz treeright
     
     
     mov ah,00
     int 16h  
                   
    ret