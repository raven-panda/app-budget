import { TextField } from "@mui/material";
import { useEffect, useState } from "react";

interface FormTextFieldProps {
  id: string;
  name: string;
  type: string;
  label: string;

  formSubmitted: boolean;
  originalValue?: string;
  pattern?: RegExp;
  patternMessage?: string;
  minLength?: number;
}

export function FormTextField({id, name, type, formSubmitted, label, originalValue = "", pattern = new RegExp(""), patternMessage = "", minLength = 0}: FormTextFieldProps) {
  const [value, setValue] = useState(originalValue);
  const [isValid, setIsValid] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const isValidPattern = !!pattern ? !!value.match(pattern) : true;
    
    const isValidMinLength = value.length >= minLength;

    if (!formSubmitted) return;
    if (!isValidPattern) {
      setIsValid(false);
      setError(patternMessage);
    } else if (!isValidMinLength) {
      setIsValid(false);
      setError(`Veuillez entrer au moins ${minLength} caractères`);
    } else {
      setIsValid(true);
      setError("");
    }
  }, [value, formSubmitted]);
  
  return (
    <TextField
      className="w-full" 
      id={id}
      name={name}
      variant="outlined" 
      type={type}
      label={label}
      onChange={(e) => setValue(e?.target?.value?.trim())}
      error={!isValid}
      value={value}
      helperText={error}
      required
    ></TextField>
  );
}