import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";


export function DivFormElement({ textLabel, type, name, id, placeholder = '' }) {

    return (
        <div className="sm:col-span-3">
        <Label text={textLabel}></Label>
        <div className="mt-2">
          <Input
            type={type}
            name={name}
            id={id}
            placeholder={placeholder}
          ></Input>
        </div>
      </div>
    );
  }
  