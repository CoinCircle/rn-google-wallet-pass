# rn-google-wallet-pass
A minimal wrapper around Google's pay client that allows to save google wallet passes to an android device


![](https://user-images.githubusercontent.com/59275080/181129256-63656460-5c90-43cf-a412-17edf770cfa7.gif)




## Installation
### note: this is a native module for Android only (not supported with expo managed workflow)

```sh
npm install rn-google-wallet-pass
```

## Usage

```js
import { isSupported, addWalletPass, addWalletPassJWT } from 'rn-google-wallet-pass';

// ...

/* Must call isSupported first as it fetches the client */
if (await isSupported()) addWalletPass(jsonStringObject);
/* or for passing in jwt */
if (await isSupported()) addWalletPassJWT(jwtJsonStringObject);
// note: isSupported is async as it requires fetching the google pay client
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## Helpful resources:
[PayClient api](https://developers.google.com/android/reference/com/google/android/gms/pay/PayClient) (This is the Android SDK API)
[Google IO Reveal](https://www.youtube.com/watch?v=2gTCghy-dU4) (helpful intro)
## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
