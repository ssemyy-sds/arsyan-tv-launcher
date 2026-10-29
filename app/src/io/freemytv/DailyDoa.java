package io.freemytv;

import java.util.Calendar;

final class DailyDoa {
    static final class Entry {
        final String title;
        final String arabic;
        final String translation;

        Entry(String title, String arabic, String translation) {
            this.title = title;
            this.arabic = arabic;
            this.translation = translation;
        }
    }

    private static final Entry[] ENTRIES = {
        new Entry(
            "DOA HARIAN · QS. AL-BAQARAH: 45",
            "وَاسْتَعِينُوا بِالصَّبْرِ وَالصَّلَاةِ ۚ وَإِنَّهَا لَكَبِيرَةٌ إِلَّا عَلَى الْخَاشِعِينَ",
            "Dan mohonlah pertolongan (kepada Allah) dengan sabar dan salat. Dan (salat) itu sungguh berat, kecuali bagi orang-orang yang khusyuk."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-BAQARAH: 201",
            "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
            "Ya Tuhan kami, berilah kami kebaikan di dunia dan kebaikan di akhirat, dan lindungilah kami dari azab neraka."
        ),
        new Entry(
            "DOA HARIAN · QS. ALI 'IMRAN: 8",
            "رَبَّنَا لَا تُزِغْ قُلُوبَنَا بَعْدَ إِذْ هَدَيْتَنَا وَهَبْ لَنَا مِنْ لَدُنْكَ رَحْمَةً ۚ إِنَّكَ أَنْتَ الْوَهَّابُ",
            "Ya Tuhan kami, janganlah Engkau condongkan hati kami kepada kesesatan setelah Engkau beri petunjuk, dan karuniakanlah rahmat dari sisi-Mu."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-ISRA: 24",
            "رَبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا",
            "Wahai Tuhanku, sayangilah kedua orang tuaku sebagaimana mereka berdua telah mendidik aku pada waktu kecil."
        ),
        new Entry(
            "DOA HARIAN · QS. THAHA: 25-28",
            "رَبِّ اشْرَحْ لِي صَدْرِي وَيَسِّرْ لِي أَمْرِي وَاحْلُلْ عُقْدَةً مِنْ لِسَانِي يَفْقَهُوا قَوْلِي",
            "Ya Tuhanku, lapangkanlah dadaku, mudahkanlah urusanku, dan lepaskanlah kekakuan lidahku, agar mereka mengerti perkataanku."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-ANBIYA: 87",
            "لَا إِلَٰهَ إِلَّا أَنْتَ سُبْحَانَكَ إِنِّي كُنْتُ مِنَ الظَّالِمِينَ",
            "Tidak ada tuhan selain Engkau, Mahasuci Engkau. Sungguh, aku termasuk orang-orang yang zalim."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-FURQAN: 74",
            "رَبَّنَا هَبْ لَنَا مِنْ أَزْوَاجِنَا وَذُرِّيَّاتِنَا قُرَّةَ أَعْيُنٍ وَاجْعَلْنَا لِلْمُتَّقِينَ إِمَامًا",
            "Ya Tuhan kami, anugerahkanlah kami pasangan dan keturunan sebagai penyejuk hati, dan jadikanlah kami pemimpin orang bertakwa."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-MU'MINUN: 118",
            "رَبِّ اغْفِرْ وَارْحَمْ وَأَنْتَ خَيْرُ الرَّاحِمِينَ",
            "Ya Tuhanku, berilah ampunan dan berilah rahmat, Engkaulah sebaik-baik pemberi rahmat."
        ),
        new Entry(
            "DOA HARIAN · QS. AL-KAHFI: 10",
            "رَبَّنَا آتِنَا مِنْ لَدُنْكَ رَحْمَةً وَهَيِّئْ لَنَا مِنْ أَمْرِنَا رَشَدًا",
            "Ya Tuhan kami, berikanlah rahmat kepada kami dari sisi-Mu dan sempurnakanlah petunjuk yang lurus bagi kami dalam urusan kami."
        ),
        new Entry(
            "DOA HARIAN · QS. IBRAHIM: 40",
            "رَبِّ اجْعَلْنِي مُقِيمَ الصَّلَاةِ وَمِنْ ذُرِّيَّتِي ۚ رَبَّنَا وَتَقَبَّلْ دُعَاءِ",
            "Ya Tuhanku, jadikanlah aku dan anak cucuku orang yang tetap melaksanakan salat, ya Tuhan kami, perkenankanlah doaku."
        ),
        new Entry(
            "DOA PAGI · HR. IBNU MAJAH",
            "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمًا نَافِعًا وَرِزْقًا طَيِّبًا وَعَمَلًا مُتَقَبَّلًا",
            "Ya Allah, sesungguhnya aku memohon kepada-Mu ilmu yang bermanfaat, rezeki yang baik, dan amal yang diterima."
        ),
        new Entry(
            "DOA HARIAN · HR. BUKHARI",
            "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ وَالْعَجْزِ وَالْكَسَلِ وَالْجُبْنِ وَالْبُخْلِ",
            "Ya Allah, aku berlindung kepada-Mu dari rasa gundah dan sedih, dari kelemahan dan kemalasan, serta sifat pengecut dan kikir."
        ),
        new Entry(
            "DOA HARIAN · HR. MUSLIM",
            "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْهُدَى وَالتُّقَى وَالْعَفَافَ وَالْغِنَى",
            "Ya Allah, sesungguhnya aku memohon kepada-Mu petunjuk, ketakwaan, kesucian diri, dan kecukupan."
        ),
        new Entry(
            "DOA HARIAN · HR. IBNU HIBBAN",
            "اللَّهُمَّ لَا سَهْلَ إِلَّا مَا جَعَلْتَهُ سَهْلًا وَأَنْتَ تَجْعَلُ الْحَزْنَ إِذَا شِئْتَ سَهْلًا",
            "Ya Allah, tidak ada kemudahan kecuali apa yang Engkau jadikan mudah, dan Engkau jadikan kesulitan mudah bila Engkau kehendaki."
        ),
        new Entry(
            "DOA HARIAN · QS. AN-NAML: 19",
            "رَبِّ أَوْزِعْنِي أَنْ أَشْكُرَ نِعْمَتَكَ الَّتِي أَنْعَمْتَ عَلَيَّ وَعَلَىٰ وَالِدَيَّ",
            "Ya Tuhanku, anugerahkanlah aku ilham untuk tetap mensyukuri nikmat-Mu yang telah Engkau limpahkan kepadaku dan kedua orang tuaku."
        )
    };

    /** Picks today's entry based on day of year. */
    static Entry today() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_YEAR);
        return ENTRIES[Math.abs(day) % ENTRIES.length];
    }
}

