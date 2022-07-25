# rn-google-wallet-pass
A minimal wrapper around Google's pay client that allows to save google wallet passes to an android device
## Installation

```sh
npm install rn-google-wallet-pass
```

## Usage

```js
import { isSupported, addWalletPass } from 'rn-google-wallet-pass';

// ...

/* Must call isSupported first as it fetches the client */
if (await isSupported()) addWalletPass(jsonStringObject);
// note: isSupported is async as it requires fetching the google pay client
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
