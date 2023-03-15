package com.example.myuniversitas;

import java.util.ArrayList;

class UnivData {
    private static String[] univNames = {
            "Universitas Gajah Mada",
            "Universitas Indonesia",
            "Institut Teknologi Bandung",
            "Institut Pertanian Bogor",
            "Universitas Diponegoro",
            "Universitas Brawijaya",
            "Institut Teknologi Sepuluh November",
            "Universitas Sebelas Maret",
            "Universitas Syiah Kuala",
            "Universitas Padjadjaran"
    };

    private static String[] univDetails = {
            "Universitas Gadjah Mada (disingkat UGM) merupakan universitas negeri di Indonesia yang didirikan oleh Pemerintah Republik Indonesia pada tanggal 19 Desember 1949 berdasarkan Peraturan Pemerintah Nomor 23 Tahun 1949 tentang Peraturan Tentang Penggabungan Perguruan Tinggi Menjadi Universiteit tanggal 16 Desember 1949. Kampus UGM yang terletak di Yogyakarta merupakan universitas pertama yang didirikan oleh Pemerintah Republik Indonesia setelah Indonesia merdeka.",
            "Universitas Indonesia disingkat sebagai UI, adalah sebuah perguruan tinggi di Indonesia. Kampus utamanya terletak di bagian Utara dari Depok, Jawa Barat tepat di perbatasan antara Depok dengan wilayah Jakarta Selatan, dan kampus utama lainnya terdapat di daerah Salemba di Jakarta Pusat. Universitas Indonesia adalah kampus modern, komprehensif, terbuka, multibudaya, dan humanis yang mencakup disiplin ilmu yang luas. Telah menghasilkan lebih dari 400.000 alumni.",
            "Institut Teknologi Bandung (ITB) adalah sebuah perguruan tinggi negeri yang berkedudukan di Kota Bandung. Nama ITB diresmikan pada tanggal 2 Maret 1959. Sejak tanggal 14 Oktober 2013 ITB menjadi Perguruan Tinggi Negeri Badan Hukum (PTN BH) yang memiliki otonomi pengelolaan dalam akademik dan nonakademik. ITB telah memiliki 27 program studi yang terakreditasi secara internasional (sebelas dari ABET, sebelas dari ASIIN).",
            "Institut Pertanian Bogor (nama bahasa Inggris: IPB University, sebelumnya Bogor Agricultural University) adalah sebuah perguruan tinggi pertanian negeri yang berkedudukan di Bogor. Sebelum diresmikan pada tahun 1963, IPB adalah sebuah fakultas pertanian pada Universitas Indonesia. Pada tanggal 1 September 1963. Presiden Pertama Indonesia, Ir. Soekarno, melakukan peletakkan batu pertama pembangunan kampus sekaligus menandai peresmian Institut Pertanian Bogor sebagai sebuah perguruan tinggi mandiri.",
            "Universitas Diponegoro disingkat Undip, adalah sebuah Perguruan Tinggi Negeri di Indonesia yang berlokasi di Semarang, Jawa Tengah, Indonesia. Undip didirikan pada tahun 1956 sebagai Perguruan Tinggi Swasta dan baru mendapat status sebagai Perguruan Tinggi Negeri pada tahun 1961. Kata Diponegoro diambil dari nama pahlawan nasional, yaitu Pangeran Diponegoro yang merupakan seorang pangeran pengobar semangat kemerdekaan dari tindakan kolonialisme Belanda di awal abad ke-18. Semangat ini turut menginspirasi pendirian Undip. Universitas Diponegoro memperoleh akreditasi A (Sangat Baik) dengan skor 361 dari Badan Akreditasi Nasional Perguruan Tinggi yang berlaku sejak 2013–2018. Berdasarkan Peraturan Pemerintah Nomor 52 Tahun 2015, Undip ditetapkan statusnya menjadi Perguruan Tinggi Negeri Badan Hukum.",
            "Universitas Brawijaya (UB) adalah perguruan tinggi di Indonesia yang berdiri pada tahun 1963 di Kota Malang, Jawa Timur melalui Ketetapan Menteri Pendidikan dan Ilmu Pengetahuan no.1 tanggal 5 Januari 1963. Tanggal tersebut kemudian ditetapkan sebagai Dies Natalis UB. Nama Brawijaya diberikan khusus oleh Presiden Soekarno dengan harapan mampu gemilang seperti Raden Wijaya (Brawijaya I) selaku pendiri Kerajaan Majapahit sekaligus menjadi kampus kebanggan bangsa Indonesia.",
            "Institut Teknologi Sepuluh Nopember (disingkat ITS) adalah perguruan tinggi negeri yang terletak di Surabaya. ITS awalnya didirikan oleh Yayasan Perguruan Tinggi Teknik (YPTT) yang diketuai oleh dr. Angka Nitisastro pada tanggal 10 November 1957.",
            "Sebelas Maret pukul 10.00 WIB, dengan dibacanya Keputusan Presiden Republik Indonesia tentang pembukaan “Universitas Negeri Surakarta Sebelas Maret”, maka Universitas Sebelas Maret (UNS) resmi berdiri sebagai Perguruan Tinggi Negeri di Solo. Pemandangan yang meriah meramaikan peresmian universitas negeri yang telah ditunggu kelahirannya sejak lama itu. Cikal bakal UNS sendiri dapat dirunut jejaknya dari 1950-an.",
            "Universitas Syiah Kuala (disingkat Unsyiah) adalah perguruan tinggi negeri di Banda Aceh, Indonesia, yang berdiri pada 2 September 1961. Universitas ini terletak di Banda Aceh, tepatnya di Kota Pelajar dan Mahasiswa (disingkat Kopelma), Darussalam. Kampus Unsyiah berjarak 8 km ke arah timur Kota Banda Aceh, 22 km dari Bandara Sultan Iskandar Muda, dan 10 km dari Pelabuhan Malahayati di Krueng Raya.",
            "Universitas Padjadjaran (disingkat Unpad) adalah sebuah perguruan tinggi negeri di Bandung, Jawa Barat, Indonesia. Sejak 20 Oktober 2014, status universitas berubah menjadi Perguruan Tinggi Negeri Badan Hukum (PTN BH) dari sebelumnya berstatus Badan Layanan Umum (BLU). Peresmian itu ditandai dengan peraturan pemerintah (PP) yang ditandatangani Presiden Susilo Bambang Yudhoyono. Penetapan itu didasarkan atas evaluasi kinerja yang dilakukan tim independen yang dibentuk oleh Kementerian Pendidikan dan Kebudayaan (Kemendikbud). Berdasarkan Keputusan Badan Akreditasi Nasional Perguruan Tinggi (BAN PT) tertanggal 16 Januari 2014, Unpad mendapat peringkat A (sangat baik)."
    };

    private static int[] univImages = {
            R.drawable.ugm,
            R.drawable.ui,
            R.drawable.itb,
            R.drawable.ipb,
            R.drawable.undip,
            R.drawable.ub,
            R.drawable.its,
            R.drawable.uns,
            R.drawable.unsyiah,
            R.drawable.unpad
    };

    static ArrayList<Univ> getListData() {
        ArrayList<Univ> list = new ArrayList<>();
        for(int position = 0; position < univNames.length; position++) {
            Univ univ = new Univ();
            univ.setName(univNames[position]);
            univ.setDetail(univDetails[position]);
            univ.setPhoto(univImages[position]);
            list.add(univ);
        }
        return list;
    }
}
