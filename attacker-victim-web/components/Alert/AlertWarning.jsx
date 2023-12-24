
function AlertWarning({description, title}) {
    return (
        <div className="relative items-center w-full px-5 py-12 mx-auto md:px-12 lg:px-24 max-w-7xl">
          <div className="p-6 border-l-4 border-yellow-600 rounded-r-xl bg-yellow-50">
            <div className="flex">
              <div className="flex-shrink-0">
                <svg className="w-5 h-5 text-yellow-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true" data-darkreader-inline-fill="">
                  <path fill-rule="evenodd" d="M8.257 3.099c.765-1.36 2.722-1.36 3.486 0l5.58 9.92c.75 1.334-.213 2.98-1.742 2.98H4.42c-1.53 0-2.493-1.646-1.743-2.98l5.58-9.92zM11 13a1 1 0 11-2 0 1 1 0 012 0zm-1-8a1 1 0 00-1 1v3a1 1 0 002 0V6a1 1 0 00-1-1z" clip-rule="evenodd"></path>
                </svg>
              </div>
              <div className="ml-3">
              <h3 class="text-sm font-medium text-yellow-600">{title}</h3>
                <div className="mt-2 text-sm text-yellow-600">
                  <p>{description}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
    );
  }
  
  export default AlertWarning;
  