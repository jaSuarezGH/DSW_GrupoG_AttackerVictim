"use client";

import "@/tailwind.config";
import { useRouter } from "next/navigation";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { Routes } from "./models/routes.model";
import Link from "next/link";


export default function RootPage() {
  const router = useRouter();

  return (
    <>
      <div className="px-6 pb-8 pt-2 mt-20 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
        <DivImageHeader
          title="Bienvenido a AttackerVictim"
        ></DivImageHeader>

        <div className="mt-10  sm:mx-auto sm:w-full sm:max-w-sm">

              <Link href={Routes.SIGN_IN}>
              <ButtonSubmit text="Ingresar al Sistema"></ButtonSubmit>
              </Link>
              
        </div>
      </div>
    </>
  );
}
