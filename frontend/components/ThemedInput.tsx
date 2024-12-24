import React from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  TextInputProps,
  ViewStyle,
  TextStyle,
} from "react-native";

type ThemedInputProps = TextInputProps & {
  label?: string;
  hint?: string;
  bubbleColor?: string;
  textColor?: string;
  labelColor?: string;
  hintColor?: string;
  style?: ViewStyle;
  labelStyle?: TextStyle;
  hintStyle?: TextStyle;
};

const ThemedInput: React.FC<ThemedInputProps> = ({
  label = "Label",
  hint = "Hint",
  value,
  onChangeText,
  placeholder = "Enter text",
  bubbleColor = "#f0f0f0",
  textColor = "#333",
  labelColor = "#666",
  hintColor = "#999",
  style,
  labelStyle,
  hintStyle,
  ...props
}) => {
  return (
    <View style={[styles.container, { backgroundColor: bubbleColor }, style]}>
      {label ? (
        <Text style={[styles.label, { color: labelColor }, labelStyle]}>
          {label}
        </Text>
      ) : null}
      <TextInput
        style={[styles.input, { color: textColor }]}
        value={value}
        onChangeText={onChangeText}
        placeholder={placeholder}
        placeholderTextColor={hintColor}
        {...props}
      />
      {hint ? (
        <Text style={[styles.hint, { color: hintColor }, hintStyle]}>
          {hint}
        </Text>
      ) : null}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    borderRadius: 20,
    paddingVertical: 10,
    paddingHorizontal: 15,
    marginVertical: 10,
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  label: {
    fontSize: 14,
    fontWeight: "600",
    marginBottom: 5,
  },
  input: {
    fontSize: 16,
    paddingVertical: 5,
  },
  hint: {
    fontSize: 12,
    marginTop: 5,
  },
});

export default ThemedInput;
