
export function ButtonRedirect({text, styles = "px-3 py-1.5 text-sm"}) {
    return (
      <button
        type="button"
        className={`flex w-full justify-center rounded-md bg-indigo-600 leading-6 text-white font-semibold shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600 ${styles}`}
      >
        {text}
      </button>
    );
  }
  
  