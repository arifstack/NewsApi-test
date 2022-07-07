# DigimasterNewsApi

### How the app works
1. This app will show a list of news from [Newsapi.org](newsapi.org) REST API
2. Create your account
3. Get Your Api Key
3. Copy your api key and paste to `Build.gradle(Module ..)`

### Prerequisites

Before running this app, you need to add your NewsAPi Key, in your `Build.gradle(Module ..)` file:

```yaml
buildConfigField "String","API_SECRET","PUT YOUR API KEY IN HERE"
```

### Dependencies :
- [Lifecycle & Livedata](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Retrofit 2](https://square.github.io/retrofit/)    
- [OkHttp 3](https://square.github.io/okhttp/)    
- [Glide](https://github.com/bumptech/glide)    
- [AndroidX](https://mvnrepository.com/artifact/androidx)
- [KotlinX Coroutines](https://developer.android.com/kotlin/coroutines)
- [Circle ImageView](https://github.com/hdodenhof/CircleImageView)
- [Lottie Android](https://github.com/airbnb/lottie-android)
- [RoomDatabase](https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase)
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore)
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
