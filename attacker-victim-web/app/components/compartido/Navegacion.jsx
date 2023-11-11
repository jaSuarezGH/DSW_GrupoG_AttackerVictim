"use client"

import { Disclosure } from "@headlessui/react";
import {
  Bars3Icon,
  Cog6ToothIcon,
  XMarkIcon,
} from "@heroicons/react/24/outline";

import { useRouter } from "next/navigation";
import { useState } from "react";


const userNavigation = [
  { name: "Configuracion", href: "#" },
  { name: "Cerrar Sesion", href: "/pages/login" },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}


const navigation = [
  { name: "Funcionalidades", href: "/pages/principal", current: true },
  { name: "Victima", href: "#", current: false },
  { name: "Atacante", href: "#", current: false },
  { name: "Consultar Posicionamiento", href: "#", current: false },
  { name: "Notificaciones", href: "#", current: false },
];

export function Navegacion({number = 0}) {

  // Establecer en que pagina estoy:
  navigation.map((item) => {
    item.current = false;
  })

  navigation[number].current = true;


  const router = useRouter();

  const [isClick, setIsClick] = useState(false)

  const onClick = (e) => {
    if (!isClick) {
      router.push("/pages/login");
    }
    setIsClick(true);
  };



  return (
    <>
      <div className="min-h-full min-w-full sticky top-0">
        <Disclosure as="nav" className="bg-gray-800">
          {({ open }) => (
            <>
              <div className="mx-auto max-w-full px-4 sm:px-6 lg:px-8">
                <div className="flex h-16 items-center justify-between">
                  <div className="flex items-center">
                    <div className="flex-shrink-0 mr-4">
                      <img
                        className="h-14 w-14"
                        src="/logo-fondo-casa.png"
                        alt="AttackVictim"
                      />
                    </div>
                    <div className="hidden md:block">
                      <div className="ml-1 flex items-baseline space-x-4">
                        {navigation.map((item) => (
                          <a
                            key={item.name}
                            href={item.href}
                            className={classNames(
                              item.current
                                ? "bg-gray-900 text-white"
                                : "text-gray-300 hover:bg-gray-700 hover:text-white",
                              "rounded-md px-3 py-2 text-sm font-medium"
                            )}
                            aria-current={item.current ? "page" : undefined}
                          >
                            {item.name}
                          </a>
                        ))}
                      </div>
                    </div>
                  </div>
                  <div className="hidden md:block">
                    <div className="ml-4 flex items-center md:ml-6">
                      <button
                        type="button"
                        className=" mr-7 relative rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"
                      >
                        <span className="absolute -inset-1.5" />
                        <span className="sr-only">Configuracion</span>
                        <Cog6ToothIcon className="h-6 w-6" aria-hidden="true" />
                      </button>

                      <button
                        className="bg-rose-700 text-white rounded-md px-3 py-2 text-sm font-medium"
                        onClick={onClick}
                      >
                        Cerrar Sesion
                      </button>
                    </div>
                  </div>
                  <div className="-mr-2 flex md:hidden">



                    {/* Mobile menu button */}
                    <Disclosure.Button className="relative inline-flex items-center justify-center rounded-md bg-gray-800 p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                      <span className="absolute -inset-0.5" />
                      <span className="sr-only">Open main menu</span>
                      {open ? (
                        <XMarkIcon
                          className="block h-6 w-6"
                          aria-hidden="true"
                        />
                      ) : (
                        <Bars3Icon
                          className="block h-6 w-6"
                          aria-hidden="true"
                        />
                      )}
                    </Disclosure.Button>
                  </div>
                </div>
              </div>

              <Disclosure.Panel className="md:hidden">
                <div className="space-y-3 px-2 pb-3 pt-2 sm:px-3">
                  {navigation.map((item) => (
                    <Disclosure.Button
                      key={item.name}
                      as="a"
                      href={item.href}
                      className={classNames(
                        item.current
                          ? "bg-gray-900 text-white"
                          : "text-gray-300 hover:bg-gray-700 hover:text-white",
                        "block rounded-md px-3 py-2 text-base font-medium"
                      )}
                      aria-current={item.current ? "page" : undefined}
                    >
                      {item.name}
                    </Disclosure.Button>
                  ))}
                </div>
                <div className="border-t border-gray-700 pb-3 pt-4">
                  <div className="flex items-center px-5"></div>
                  <div className="mt-3 space-y-3 px-2 pb-4">
                    {userNavigation.map((item) => (
                      <Disclosure.Button
                        key={item.name}
                        as="a"
                        href={item.href}
                        className="block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white"
                      >
                        {item.name}
                      </Disclosure.Button>
                    ))}
                  </div>
                </div>
              </Disclosure.Panel>
            </>
          )}
        </Disclosure>
        </div>
    </>
  );
}

/* Parte del codigo opcional para mostrar un titulo (header) relacionado con la barra de Navegacion: */
/* 
<header className="border-b-2 bg-white shadow">
<div className="mx-auto max-w-full px-4 py-6 sm:px-6 lg:px-8">
  {navigation.map((item) => (
      <h1 
        key={item.name} 
        className="ml-3 text-3xl font-bold tracking-tight text-gray-900">
          {item.current ? item.name : null}
      </h1>
  ))}
</div>
</header> */
