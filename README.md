# Arsyan TV Launcher

A clean, modern, and aesthetic Android TV launcher inspired by Nothing OS and Apple TV design philosophies. Built for Android TV devices with fluid glassmorphism, clean typography, live weather, real-time exchange rates, and automatic Adzan prayer time notifications specifically tailored for Kota Batam.

---

## 📺 Showcase

### 1. Minimalist Home Screen
Clean typography display for clock, weather, and prayer countdown without bulky card boxes, blending seamlessly into dynamic wallpapers.

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

- **Clean Typography UI**: Restores the minimalist typographic aesthetic without frosted card boxes obscuring the wallpaper.
- **Prayer Times & Adzan for Kota Batam**:
  - Automatically calculates the five daily prayer times (Subuh, Dzuhur, Ashar, Maghrib, Isya) for Kota Batam (`1.1301° N, 104.0529° E`).
  - Next prayer countdown displayed directly on the home screen.
  - Background alarm scheduling (`AlarmManager.RTC_WAKEUP`) ensures timely alerts even if the launcher is in the background or sleeping.
  - **Smart Audio Focus Management**: Automatically pauses background media apps (YouTube, Spotify, video players) during the Adzan call, and seamlessly resumes playback once the Adzan finishes or is dismissed.
  - **Floating Banner Overlay**: Displays a sleek frosted-glass alert banner on top of other running apps (e.g. while watching YouTube) without stealing remote control focus.
  - High-priority system heads-up notification and centered on-screen modal banner.
  - Clear Adzan audio playback with one-click silence using any remote control key.
- **Brand Identity & Aesthetic Assets**:
  - Distinctive Konsep A branding: 3D crystal frosted monogram "A" with embedded play button and luminous cyan/silver neon accents.
  - Custom 16:9 Android TV Leanback launcher banner.
- **Adzan Sound Control**:
  - **TV Settings**: `Pengaturan (Settings) > Widget > Jadwal Sholat & Adzan > Suara adzan` on/off toggle.
  - **Drawer Widget**: Interactive prayer times card with visual sound badge (`Suara Adzan: Aktif` / `Suara Adzan: Senyap`) and instant toggle on click.
  - **Home Status**: Displays `(senyap)` on the prayer widget line when audio is muted.
- **Weather & Exchange Rates**:
  - Open-Meteo integration for accurate temperature, conditions, and daily high/low.
  - Real-time SGD and USD currency exchange rates.
- **Smooth Animations & Hardware Efficiency**:
  - Optimized for low-end to high-end Android TV boxes and Smart TVs (ZTE, Mi Box, TCL, Sony, etc.).
  - Lightweight custom drawing pipeline using native Android `Canvas` without heavy framework overhead.

---

## 🛠️ Building & Installing

### Prerequisites
- JDK 17+ or JDK 21+ (compatible with modern JDKs)
- Android SDK (`build-tools 34.0.0` or `35.0.0`, `platforms/android-34`)
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
- **[WeatherGlass TV](https://github.com/faizaldjoo/weatherglass-tv)** by [faizaldjoo](https://github.com/faizaldjoo) – For the Islamic prayer calculations and weather glass UI inspiration.

---

## 📄 License

This repository is distributed under the MIT License. See [LICENSE](LICENSE) for details.
