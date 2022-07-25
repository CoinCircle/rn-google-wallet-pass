import * as React from 'react';

import { StyleSheet, View, Button, Alert } from 'react-native';
import { isSupported, addWalletPass } from 'rn-google-wallet-pass';

export default function App() {
  const handleAddPass = () => {
    const json = ``;
    if (!json) return;
    addWalletPass(json);
  };

  return (
    <View style={styles.container}>
      <Button
        title="IsPassSupported"
        onPress={async () => Alert.alert(`${await isSupported()}`)}
      />
      <Button title="AddPass" onPress={handleAddPass} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'space-around',
  },
});
