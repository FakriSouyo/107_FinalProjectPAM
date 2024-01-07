# Project Name
Jogging App

##Description
Jogging App adalah aplikasi pencatatan jogging yang memungkinkan pengguna mencatat dan melacak aktivitas jogging mereka, termasuk jarak yang ditempuh, 
kalori yang terbakar, dan waktu yang dihabiskan. User dapat membuat aktivitas, kemudian dapat mengubah progres berat, menghapus aktivitas dan
melihat aktivas joging yang telah dibuat. Aplikasi ini menggunakan Room Database untuk menyimpan data pengguna di perangkat lokal dan Google 
Maps API untuk melacak rute jogging.Aplikasi ini tidak menyediakan auth sistem, hanya saja user perlu memasukan data sebelum mengakses 
aplikasi seperti nama, jenis kelamin dan berat, kemudian aplikasi ini meminta untuk mengakses lokasi perangkat untuk dapat melacak rute joging.

##Use Case 

![Jogging app](https://github.com/FakriSouyo/107_FinalProjectPAM/assets/63139619/b41bd1d4-4da6-4192-a126-ef4052d5c5b1)


1. Pendaftaran Pengguna
Aktor: Pengguna
Deskripsi: Pengguna memasukkan informasi awal mereka sebelum menggunakan aplikasi.
- Pengguna membuka aplikasi untuk pertama kalinya.
- Aplikasi meminta pengguna untuk memasukkan nama, jenis kelamin, dan berat badan.
- Pengguna mengisi formulir pendaftaran.
- Aplikasi menyimpan data pengguna ke dalam Room Database.

2. Memulai Joging
Aktor: Pengguna
Deskripsi: Pengguna memulai sesi jogging dan mencatat informasi terkait.
- Pengguna membuka aplikasi dan masuk.
- Pengguna memilih opsi "Mulai Joging" dari menu utama.
- Aplikasi memulai pelacakan waktu dan lokasi menggunakan Google Maps API.
- Pengguna berlari dan mengakhiri sesi jogging.
= Aplikasi menghentikan pelacakan dan menyimpan data aktivitas ke dalam Room Database.

3. Melihat Riwayat Aktivitas Joging
Aktor: Pengguna
Deskripsi: Pengguna melihat riwayat sesi jogging mereka.
- Pengguna membuka aplikasi dan masuk.
- Pengguna memilih Aktivitas yang telah dibuat di menu utama.
- Aplikasi menampilkan daftar sesi jogging sebelumnya.
- Pengguna memilih satu sesi untuk melihat detailnya.

4. Menghapus Sesi Joging
Aktor: Pengguna
Deskripsi: Pengguna menghapus sesi jogging yang tidak relevan.
- Aplikasi menampilkan daftar sesi jogging sebelumnya.
- Pengguna memilih salah satu aktivitas yang telah dibuat.
- Pengguna memilih satu sesi untuk dihapus.
- Aplikasi mengonfirmasi penghapusan dan menghapus sesi dari Room Database.

5. Menampilkan Informasi Aktivitas Joging
Aktor: Pengguna
Deskripsi: Pengguna melihat ringkasan informasi terkait aktivitas jogging mereka.
- Pengguna membuka aplikasi dan masuk.
- Pengguna melihat statistik yang berada di profile yang mencakup jarak yang ditempuh, kalori yang terbakar, dan waktu yang dihabiskan.
- Aplikasi menampilkan grafik atau statistik yang memberikan pandangan visual tentang perkembangan pengguna seiring waktu.

6. Mengubah Data Informasi
Aktor: Pengguna
Deskripsi: Pengguna mengakses dan mengubah pengaturan pribadi mereka.
- pengguna dapat mengubah informasi berat badan jika terjadi progres selama melakukan aktivitas




