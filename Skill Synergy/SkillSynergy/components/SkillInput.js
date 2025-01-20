// components/SkillInput.js
import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet } from 'react-native';

export default function SkillInput({ onAddSkill }) {
  const [skill, setSkill] = useState('');

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="Enter a skill"
        value={skill}
        onChangeText={setSkill}
      />
      <Button
        title="Add Skill"
        onPress={() => {
          onAddSkill(skill);
          setSkill('');
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flexDirection: 'row', marginVertical: 10 },
  input: { flex: 1, borderBottomWidth: 1, marginRight: 10 },
});
