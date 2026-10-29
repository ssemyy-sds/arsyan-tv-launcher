# Arsyan TV Launcher v2.0

A clean, modern, and aesthetic Android TV launcher inspired by Nothing OS and Apple TV design philosophies. Built natively for Android TV and Google TV devices with fluid glassmorphism, clean typography, live dynamic weather, real-time Air Quality Index (AQI), currency exchange rates, daily Islamic prayers/ayahs, and automatic Adzan prayer time notifications specifically tailored for Kota Batam.

---

## 📺 Showcase

### 1. Minimalist Home Screen (v2.0)
Clean typography layout for the clock, real-time weather, AQI index, prayer countdown, and daily prayers (Doa Harian) floating seamlessly on top of dynamic live wallpapers.

![Home Screen](screenshots/home_screen.png)

---

### 2. Centered Adzan Notification (~50% Screen)
An elegant, frosted smoked-glass modal (50% width) displayed in the center of the screen when prayer time arrives, accompanied by full Adzan audio that can be silenced immediately with any remote button.

![Adzan Notification Banner](screenshots/adzan_banner.png)

---

### 3. Widget & Sound Settings
Easily toggle Adzan sound on or off directly through the TV settings or within the drawer widget area.

![Settings Widgets](screenshots/settings_widgets.png)

---

## ✨ Features

- **Exclusive Focus on Android TV**:
  - Engineered natively for Android TV & Google TV (API 28+ / Android 9 to Android 14+).
  - Lightweight custom drawing pipeline using native Android `Canvas` without heavy WebView or hybrid framework overhead (runs at smooth 60 fps).
- **Daily Prayer & Ayah (Doa Harian)**:
  - Curated collection of authentic Quranic ayahs and prophetic daily prayers.
  - Automatically rotates every day based on the calendar date.
  - Rendered with clear Arabic typography with full tashkeel/harakat, chapter & verse reference header, and Indonesian translation.
  - Frameless floating typography positioned symmetrically with the clock and adapting to day/night tones.
- **Air Quality Index (AQI) for Kota Batam**:
  - Live Air Quality data integration via Open-Meteo Air Quality API.
  - Displays US AQI values and qualitative categories (`Baik`, `Sedang`, `Sensitif`, `Tidak Sehat`, dll.) directly alongside the weather line.
- **Prayer Times & Adzan for Kota Batam**:
  - Automatically calculates the five daily prayer times (Subuh, Dzuhur, Ashar, Maghrib, Isya) for Kota Batam (`1.1301° N, 104.0529° E`).
  - Next prayer countdown displayed directly on the home screen.
  - Background alarm scheduling (`AlarmManager.RTC_WAKEUP`) ensures timely alerts even if the launcher is in the background or sleeping.
  - **Smart Audio Focus Management**: Automatically pauses background media apps (YouTube, Spotify, video players) during the Adzan call, and seamlessly resumes playback once dismissed.
  - **Floating Banner Overlay**: Displays a sleek frosted-glass alert banner on top of other running apps without stealing remote control focus.
  - Full Adzan audio playback with one-click silence using any remote control key.
- **Weather & Exchange Rates**:
  - Open-Meteo integration for accurate temperature, conditions, and daily high/low.
  - Real-time SGD and USD currency exchange rates.
- **Clean Typography UI**:
  - Restores the minimalist typographic aesthetic without frosted card boxes obscuring the wallpaper.
- **Smooth Animations & Hardware Efficiency**:
  - Highly optimized for low-end to high-end Android TV boxes and Smart TVs (ZTE, Mi Box, TCL, Sony, etc.).

---

## 🛠️ Building & Installing

### Prerequisites
- JDK 17+ or JDK 21+ (compatible with modern JDKs, including JDK 26)
- Android SDK (`build-tools 35.0.0` or `34.0.0`, `platforms/android-34`)
- ADB tools for TV connection

### Build APK
Run the build script:
```bash
bash ./build.sh
```
This compiles the project and produces **`ArsyanTV.apk`** in the root directory.

### Install to Android TV
1. Enable **Developer Options** and **Network Debugging / USB Debugging** on your Android TV.
2. Connect to your TV over ADB:
   ```bash
   adb connect <TV_IP_ADDRESS>:5555
   ```
3. Install the APK:
   ```bash
   adb -s <TV_IP_ADDRESS>:5555 install -r ArsyanTV.apk
   ```
4. Grant the display overlay permission (for the on-screen Adzan banner over other apps):
   ```bash
   adb -s <TV_IP_ADDRESS>:5555 shell appops set io.freemytv SYSTEM_ALERT_WINDOW allow
   ```
   *(Alternatively, toggle on in TV Settings: **Apps > Special app access > Display over other apps > Arsyan TV**).*

---

## 🙏 Credits & Acknowledgments

This project is built upon the wonderful work of the open-source community:

- **[Free My TV](https://github.com/simbasjungles/free-my-tv)** by [simbasjungles](https://github.com/simbasjungles) – The foundational open-source Android TV launcher codebase and design architecture.
- **[WeatherGlass TV](https://github.com/faizaldjoo/weatherglass-tv)** by [faizaldjoo](https://github.com/faizaldjoo) – Islamic prayer calculations and weather glass UI inspiration.
- Modified and maintained by **semy** (Arsyan TV).

---

## 📄 License

This repository is distributed under the MIT License. See [LICENSE](LICENSE) for details.
