# Pertemuan 01 — Introduction to Object Oriented Programming

## 📖 Deskripsi

Pertemuan pertama membahas pengenalan **Pemrograman Berorientasi Objek (PBO)** atau *Object Oriented Programming (OOP)* pada mata kuliah **Pemrograman Berorientasi Objek (CSF308)**.

Pada pertemuan ini dipelajari konsep dasar PBO, perbedaan antara pemrograman prosedural dengan pemrograman berorientasi objek, empat prinsip dasar OOP, karakteristik dan fitur OOP, istilah-istilah dasar dalam Java, serta pembuatan program Java sederhana.

## ✨ Tujuan Pembelajaran

Setelah mempelajari materi pada pertemuan ini, diharapkan mahasiswa mampu:

1. Memahami konsep Pemrograman Berorientasi Objek.
2. Mendeskripsikan prinsip dasar Pemrograman Berorientasi Objek.
3. Mendeskripsikan karakteristik dan fitur-fitur Pemrograman Berorientasi Objek.

## 1. Apa itu Pemrograman Berorientasi Objek (OOP)?

**Pemrograman Berorientasi Objek (Object Oriented Programming / OOP)** merupakan paradigma pemrograman yang berorientasikan kepada **objek**, di mana semua data dan fungsi dibungkus ke dalam **class-class** atau **object-object**.

Contoh bahasa pemrograman yang mendukung PBO antara lain: **Java**, **PHP**, **Python**, dan **C++**.

Setiap objek dalam PBO memiliki dua komponen utama:

* **Attribute** → data atau karakteristik yang melekat pada suatu objek.
* **Method** → aksi atau perilaku (*behavior*) yang dapat dilakukan oleh suatu objek.

## 2. Perbedaan Pemrograman Prosedural & Pemrograman Berorientasi Objek

### 2.1 Pemrograman Prosedural

Metode pemrograman yang berorientasi pada pembentukan fungsi. Satu fungsi digunakan untuk menyelesaikan satu tugas tertentu. Fungsi-fungsi yang berkaitan biasanya dikelompokkan dan ditulis menjadi satu modul khusus yang terpisah dari file *source code* utama.

```Java
Program
 ├── Fungsi 1
 ├── Fungsi 2
 ├── ...
 └── Program Utama
```

### 2.2 Pemrograman Berorientasi Objek

Program tersusun dari kumpulan kelas ( *class* ). Satu kelas digunakan untuk memodelkan objek tertentu. Untuk keperluan modularisasi kode program, beberapa kelas yang saling berkaitan dapat disimpan ke dalam modul terpisah.

```Java
Program
 ├── Kelas 1
 ├── Kelas 2
 ├── ...
 └── Program Utama
```

## 3. Class dan Object

Class: Model atau abstraksi yang merepresentasikan objek-objek yang ada di dunia nyata. Kelas didefinisikan sebagai kerangka atau cetak biru (blueprint) untuk tipe objek baru (klasifikasi) yang menguraikan data, fungsi, serta cara objek berperilaku—mirip seperti membangun banyak rumah dari satu set cetak biru.

Object (Instance): Wujud nyata dari suatu kelas (tipe data bentukan). Seorang programmer dapat membuat satu atau lebih objek dari sebuah kelas.

```Java
Class (Blueprint / Cetak Biru)
  ↓
Object / Instance (Wujud Nyata dari Class)
```

## 4. Prinsip Dasar dalam Pemrograman Berorientasi Objek

Terdapat empat pilar atau prinsip dasar dalam PBO:

Pembungkusan (Encapsulation): Konsep penggabungan atribut dan metode ke dalam suatu entitas tunggal yang disebut kelas.

Abstraksi (Abstraction): Kemampuan sebuah program untuk melewati aspek informasi yang diproses olehnya, yaitu berfokus pada inti dan menyederhanakan kompleksitas.

Polimorfisme (Polymorphism): Kejadian di mana suatu objek dapat melakukan pekerjaan yang berbeda menggunakan satu cara yang sama, dapat terjadi ketika memiliki hierarki kelas tertentu.

Pewarisan (Inheritance): Proses pembentukan kelas baru yang diturunkan dari kelas-kelas lain yang sebelumnya sudah ada.

## 5. Pemrograman Java & Istilah Dasar OOP (OOP Terms)

Java adalah bahasa pemrograman berorientasi objek multiplatform yang bersifat open source. Sebuah bytecode Java dapat dijalankan di sistem operasi mana pun selama sistem tersebut memiliki Java Virtual Machine (JVM) yang disertakan oleh Java SDK.

```Java
Java Source Code (.java)
       ↓
   Compiler
       ↓
  Java Bytecode (.class)
       ↓
      JVM
       ↓
Operating System (Multiplatform)
```

### Istilah Dasar OOP pada Java

* **Object :** Entitas yang memiliki keadaan ( *state* ), perilaku ( *behaviour* ), dan identitas yang dirumuskan dalam suatu lingkup masalah dengan baik.
* ****Class**** : *Blueprint* dari sebuah objek atau cetakan untuk membuat objek.
* **Attribute :** Variabel yang terikat dalam suatu kelas.
* **Method :** Aksi-aksi dan perilaku yang bisa dilakukan oleh suatu objek.
* **Constructor :** Tipe khusus dari method yang digunakan untuk membuat dan menginisialisasi sebuah objek baru.

## 6. Karakteristik & Fitur Pemrograman Berorientasi Objek

## Karakteristik PBO :

1. Penekanan berada pada data dibandingkan prosedur.

2. Program dibagi menjadi beberapa objek.

3. Struktur data dirancang sedemikian rupa sehingga mencirikan objek.

4. Fungsi-fungsi yang beroperasi pada data suatu objek diikat bersama dalam struktur data.

5. Data disembunyikan dan tidak dapat diakses oleh fungsi eksternal.

6. Objek dapat berkomunikasi satu sama lain melalui fungsi (method).

## Fitur PBO :

1. Natural: Mengikuti cara berpikir manusia (manusia memandang dunianya sebagai kumpulan objek yang berinteraksi).

2. Abstraction: Menjelaskan makna sebuah entitas secara cepat dan mudah.

3. Encapsulation: Menggabungkan data (fields) dan perilaku (methods) bersama di dalam kelas (bundling).
4. Information Hiding: Dapat menyembunyikan detail internal yang tidak perlu diketahui bagian lain.
5. Modular: Objek merupakan entitas yang independen sehingga kode mudah dikelola.

## 7. Contoh Program Sederhana Java

 Contoh struktur program dasar Java menggunakan System.out.println():

```Java
package Pertemuan_01;

public class Pertemuan1_JavaApplication1 {

    public static void main(String[] args) {
        System.out.println("Hallo Pemrograman Berorientasi Objek");
    }
}
```

**Output** :

```Java
Hallo Pemrograman Berorientasi Objek
```

## 📝 Task & Quiz Pertemuan 01

## ⚙️ Task — Instalasi Environment Java

Menyiapkan lingkungan pengembangan Java (JDK) serta IDE (NetBeans / Visual Studio Code) untuk menulis, mengompilasi, dan menjalankan program Java.

## 💡 Quiz — Program Perhitungan Geometri Sederhana

Membuat program Java sederhana untuk menghitung:

1. **Soal A — Luas Segitiga:**
   $$
   \text{Luas} = \frac{1}{2} \times \text{alas} \times \text{tinggi}

   $$
2. **Soal B — Luas Persegi Panjang:**
   $$
   \text{Luas} = \text{panjang} \times \text{lebar}

   $$
3. **Soal C — Keliling Lingkaran:**
   $$
   \text{Keliling} = 2 \times \pi \times r

   $$

## 🗂️ Struktur File

```Java
Pertemuan_01/
 ├── Laporan/
 ├── Quiz/
 ├── Task/
 ├── README.md
 └── Week 1 - Intro to Object Oriented Programming.pptx
```

## ✅ Kesimpulan

Pada pertemuan pertama telah dipelajari fondasi  **Pemrograman Berorientasi Objek (PBO)** , mulai dari perbedaan paradigma prosedural dan OOP, hubungan antara *Class* sebagai cetak biru dan *Object* sebagai wujud nyatanya, empat prinsip utama OOP ( *Encapsulation, Abstraction, Polymorphism, Inheritance* ), istilah dasar OOP di Java, hingga struktur dasar program Java pertama.
