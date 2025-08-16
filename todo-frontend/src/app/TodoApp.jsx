'use client'
import React, { useState } from 'react'
import {
  Plus,
  Search,
  ChevronRight,
  Calendar,
  Star,
  Trash2,
  Circle,
  CheckCircle,
} from 'lucide-react'

const MacRemindersClone = () => {
  const [selectedList, setSelectedList] = useState('today')
  const [searchTerm, setSearchTerm] = useState('')
  const [newTask, setNewTask] = useState('')
  const [showNewTaskInput, setShowNewTaskInput] = useState(false)
  const [showNewListModal, setShowNewListModal] = useState(false)
  const [newListName, setNewListName] = useState('')
  const [newListColor, setNewListColor] = useState('blue')
  const [draggedTask, setDraggedTask] = useState(null)

  const [lists, setLists] = useState([
    { id: 'today', name: 'Hôm nay', count: 3, color: 'blue', icon: Calendar },
    {
      id: 'scheduled',
      name: 'Đã lên lịch',
      count: 8,
      color: 'red',
      icon: Calendar,
    },
    { id: 'all', name: 'Tất cả', count: 12, color: 'gray', icon: Circle },
    { id: 'flagged', name: 'Đã gắn cờ', count: 2, color: 'orange', icon: Star },
  ])

  const [customLists, setCustomLists] = useState([
    { id: 'family', name: 'Gia đình', count: 5, color: 'yellow' },
    { id: 'work', name: 'Công việc', count: 8, color: 'blue' },
    { id: 'personal', name: 'Cá nhân', count: 3, color: 'green' },
  ])

  const [tasks, setTasks] = useState([
    {
      id: 1,
      text: 'Apple Intelligence trên macOS Sequoia: ngon, chờ tiếng việt với bật nó lên',
      completed: false,
      flagged: false,
      list: 'today',
    },
    {
      id: 2,
      text: 'Post video Zenbook S 14 full',
      completed: false,
      flagged: true,
      list: 'today',
    },
    {
      id: 3,
      text: 'Test Huawei Watch D2, so với máy đo huyết áp',
      completed: false,
      flagged: false,
      list: 'scheduled',
    },
    {
      id: 4,
      text: 'Fix gợi notification to all bài summary xong',
      completed: true,
      flagged: false,
      list: 'today',
    },
    {
      id: 5,
      text: 'Chuẩn bị iPhone mới: backup từ iPhone cũ là được à khi không dùi dung lượng iCloud',
      completed: false,
      flagged: false,
      list: 'work',
    },
  ])

  const getColorClass = (color) => {
    const colors = {
      blue: 'bg-blue-500',
      red: 'bg-red-500',
      yellow: 'bg-yellow-500',
      green: 'bg-green-500',
      orange: 'bg-orange-500',
      purple: 'bg-purple-500',
      gray: 'bg-gray-500',
    }
    return colors[color] || 'bg-gray-500'
  }

  const toggleTask = (taskId) => {
    setTasks(
      tasks.map((task) =>
        task.id === taskId ? { ...task, completed: !task.completed } : task
      )
    )
  }

  const toggleFlag = (taskId) => {
    setTasks(
      tasks.map((task) =>
        task.id === taskId ? { ...task, flagged: !task.flagged } : task
      )
    )
  }

  const addTask = () => {
    if (newTask.trim()) {
      setTasks([
        ...tasks,
        {
          id: Date.now(),
          text: newTask,
          completed: false,
          flagged: false,
          list:
            selectedList === 'all' ||
            selectedList === 'today' ||
            selectedList === 'scheduled' ||
            selectedList === 'flagged'
              ? 'personal'
              : selectedList,
        },
      ])
      setNewTask('')
      setShowNewTaskInput(false)
    }
  }

  const addNewList = () => {
    if (newListName.trim()) {
      const newList = {
        id: newListName.toLowerCase().replace(/\s+/g, '-'),
        name: newListName,
        count: 0,
        color: newListColor,
      }
      setCustomLists([...customLists, newList])
      setNewListName('')
      setNewListColor('blue')
      setShowNewListModal(false)
    }
  }

  const handleDragStart = (e, task) => {
    setDraggedTask(task)
    e.dataTransfer.effectAllowed = 'move'
  }

  const handleDragEnd = () => {
    setDraggedTask(null)
  }

  const handleDragOver = (e) => {
    e.preventDefault()
    e.dataTransfer.dropEffect = 'move'
  }

  const handleDrop = (e, targetListId) => {
    e.preventDefault()
    if (draggedTask && targetListId !== 'all') {
      setTasks(
        tasks.map((task) =>
          task.id === draggedTask.id ? { ...task, list: targetListId } : task
        )
      )
    }
    setDraggedTask(null)
  }

  const getFilteredTasks = () => {
    let filtered = tasks

    if (selectedList === 'today') {
      filtered = tasks.filter((task) => task.list === 'today')
    } else if (selectedList === 'flagged') {
      filtered = tasks.filter((task) => task.flagged)
    } else if (selectedList !== 'all') {
      filtered = tasks.filter((task) => task.list === selectedList)
    }

    if (searchTerm) {
      filtered = filtered.filter((task) =>
        task.text.toLowerCase().includes(searchTerm.toLowerCase())
      )
    }

    return filtered
  }

  const getCurrentListName = () => {
    const allLists = [...lists, ...customLists]
    const current = allLists.find((list) => list.id === selectedList)
    return current ? current.name : 'Tất cả'
  }

  return (
    <div className="flex h-screen bg-gray-50">
      {/* Sidebar */}
      <div className="w-64 bg-white border-r border-gray-200 flex flex-col">
        {/* Search */}
        <div className="p-3 border-b border-gray-200">
          <div className="relative">
            <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 w-4 h-4" />
            <input
              type="text"
              placeholder="Tìm kiếm"
              className="w-full pl-10 pr-4 py-2 bg-gray-100 rounded-lg text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
            />
          </div>
        </div>

        {/* Default Lists */}
        <div className="flex-1 overflow-y-auto">
          <div className="p-2">
            {lists.map((list) => {
              const Icon = list.icon
              return (
                <div
                  key={list.id}
                  className={`flex items-center justify-between p-2 rounded-md cursor-pointer hover:bg-gray-100 transition-colors ${
                    selectedList === list.id
                      ? 'bg-blue-100 text-blue-700'
                      : 'text-gray-700'
                  } ${
                    draggedTask ? 'border-2 border-dashed border-gray-300' : ''
                  }`}
                  onClick={() => setSelectedList(list.id)}
                  onDragOver={handleDragOver}
                  onDrop={(e) => handleDrop(e, list.id)}
                >
                  <div className="flex items-center">
                    <div
                      className={`w-6 h-6 rounded-full ${getColorClass(
                        list.color
                      )} flex items-center justify-center mr-3`}
                    >
                      <Icon className="w-3 h-3 text-white" />
                    </div>
                    <span className="text-sm font-medium">{list.name}</span>
                  </div>
                  <span className="text-xs text-gray-500 bg-gray-200 px-2 py-1 rounded-full">
                    {list.count}
                  </span>
                </div>
              )
            })}
          </div>

          {/* Custom Lists */}
          <div className="border-t border-gray-200 mt-4">
            <div className="p-2">
              <div className="flex items-center justify-between px-2 py-1 text-xs font-semibold text-gray-500 uppercase tracking-wide">
                <span>Danh sách của tôi</span>
                <button
                  onClick={() => setShowNewListModal(true)}
                  className="p-1 hover:bg-gray-200 rounded"
                >
                  <Plus className="w-4 h-4 cursor-pointer hover:text-gray-700" />
                </button>
              </div>

              {customLists.map((list) => (
                <div
                  key={list.id}
                  className={`flex items-center justify-between p-2 rounded-md cursor-pointer hover:bg-gray-100 transition-colors ${
                    selectedList === list.id
                      ? 'bg-blue-100 text-blue-700'
                      : 'text-gray-700'
                  } ${
                    draggedTask ? 'border-2 border-dashed border-gray-300' : ''
                  }`}
                  onClick={() => setSelectedList(list.id)}
                  onDragOver={handleDragOver}
                  onDrop={(e) => handleDrop(e, list.id)}
                >
                  <div className="flex items-center">
                    <div
                      className={`w-6 h-6 rounded-full ${getColorClass(
                        list.color
                      )} mr-3`}
                    ></div>
                    <span className="text-sm font-medium">{list.name}</span>
                  </div>
                  <span className="text-xs text-gray-500 bg-gray-200 px-2 py-1 rounded-full">
                    {tasks.filter((task) => task.list === list.id).length}
                  </span>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>

      {/* Main Content */}
      <div className="flex-1 flex flex-col">
        {/* Header */}
        <div className="bg-white border-b border-gray-200 p-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center">
              <h1 className="text-xl font-semibold text-gray-800">
                {getCurrentListName()}
              </h1>
              <span className="ml-2 text-sm text-gray-500">
                {getFilteredTasks().length} mục
              </span>
            </div>
            <div className="flex items-center space-x-2">
              <button className="p-2 hover:bg-gray-100 rounded-full">
                <ChevronRight className="w-4 h-4 text-gray-400" />
              </button>
            </div>
          </div>
        </div>

        {/* Tasks */}
        <div className="flex-1 overflow-y-auto p-4">
          <div className="space-y-2">
            {getFilteredTasks().map((task) => (
              <div
                key={task.id}
                className={`flex items-start p-3 bg-white rounded-lg border hover:shadow-sm transition-shadow cursor-move ${
                  task.completed ? 'opacity-60' : ''
                } ${
                  draggedTask && draggedTask.id === task.id
                    ? 'opacity-50 rotate-2'
                    : ''
                }`}
                draggable="true"
                onDragStart={(e) => handleDragStart(e, task)}
                onDragEnd={handleDragEnd}
              >
                <button
                  onClick={() => toggleTask(task.id)}
                  className="mr-3 mt-0.5"
                >
                  {task.completed ? (
                    <CheckCircle className="w-5 h-5 text-blue-500" />
                  ) : (
                    <Circle className="w-5 h-5 text-gray-300 hover:text-blue-500" />
                  )}
                </button>

                <div className="flex-1">
                  <p
                    className={`text-sm ${
                      task.completed
                        ? 'line-through text-gray-500'
                        : 'text-gray-800'
                    }`}
                  >
                    {task.text}
                  </p>
                </div>

                <button onClick={() => toggleFlag(task.id)} className="ml-2">
                  <Star
                    className={`w-4 h-4 ${
                      task.flagged
                        ? 'text-orange-500 fill-current'
                        : 'text-gray-300 hover:text-orange-500'
                    }`}
                  />
                </button>
              </div>
            ))}

            {/* New Task Input */}
            {showNewTaskInput ? (
              <div className="flex items-center p-3 bg-white rounded-lg border-2 border-blue-200">
                <Circle className="w-5 h-5 text-gray-300 mr-3" />
                <input
                  type="text"
                  placeholder="Nhập nhiệm vụ mới..."
                  className="flex-1 text-sm focus:outline-none"
                  value={newTask}
                  onChange={(e) => setNewTask(e.target.value)}
                  onKeyPress={(e) => {
                    if (e.key === 'Enter') {
                      addTask()
                    }
                  }}
                  onBlur={() => {
                    if (!newTask.trim()) {
                      setShowNewTaskInput(false)
                    }
                  }}
                  autoFocus
                />
              </div>
            ) : (
              <button
                onClick={() => setShowNewTaskInput(true)}
                className="flex items-center p-3 text-gray-500 hover:text-gray-700 hover:bg-gray-50 rounded-lg transition-colors"
              >
                <Plus className="w-5 h-5 mr-3" />
                <span className="text-sm">Thêm nhiệm vụ mới</span>
              </button>
            )}
          </div>
        </div>
      </div>

      {/* New List Modal */}
      {showNewListModal && (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
          <div className="bg-white rounded-lg p-6 w-96 shadow-xl">
            <div className="flex items-center justify-between mb-4">
              <h3 className="text-lg font-semibold text-gray-800">
                Tạo danh sách mới
              </h3>
              <button
                onClick={() => setShowNewListModal(false)}
                className="text-gray-400 hover:text-gray-600"
              >
                <X className="w-5 h-5" />
              </button>
            </div>

            <div className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Tên danh sách
                </label>
                <input
                  type="text"
                  placeholder="Nhập tên danh sách..."
                  className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                  value={newListName}
                  onChange={(e) => setNewListName(e.target.value)}
                  onKeyPress={(e) => {
                    if (e.key === 'Enter') {
                      addNewList()
                    }
                  }}
                />
              </div>

              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Màu sắc
                </label>
                <div className="flex space-x-2">
                  {[
                    'blue',
                    'red',
                    'yellow',
                    'green',
                    'orange',
                    'purple',
                    'gray',
                  ].map((color) => (
                    <button
                      key={color}
                      onClick={() => setNewListColor(color)}
                      className={`w-8 h-8 rounded-full ${getColorClass(
                        color
                      )} ${
                        newListColor === color
                          ? 'ring-2 ring-offset-2 ring-gray-400'
                          : ''
                      }`}
                    />
                  ))}
                </div>
              </div>
            </div>

            <div className="flex justify-end space-x-3 mt-6">
              <button
                onClick={() => setShowNewListModal(false)}
                className="px-4 py-2 text-gray-600 hover:text-gray-800 transition-colors"
              >
                Hủy
              </button>
              <button
                onClick={addNewList}
                disabled={!newListName.trim()}
                className="px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600 disabled:bg-gray-300 transition-colors"
              >
                Tạo danh sách
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  )
}

export default MacRemindersClone
