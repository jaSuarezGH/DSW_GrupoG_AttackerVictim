
export function FillTableAllNotification({ notifications }) {
  return notifications.map((noti) => (
    <tr key={noti.id} className="bg-gray-100 border-b-2">
      <th
        scope="row"
        class="px-6 py-4 font-medium text-gray-600 whitespace-nowrap"
      >
        {noti._status}
      </th>
      <td class="px-6 py-4">{noti._user._email}</td>
      <td class="px-6 py-4">{noti._user._username}</td>
      <td class="px-6 py-4">{noti._user._personal_id}</td>
      <td class="px-6 py-4">{new Date(noti._full_date).toLocaleDateString()}</td>
    </tr>
  ));
}